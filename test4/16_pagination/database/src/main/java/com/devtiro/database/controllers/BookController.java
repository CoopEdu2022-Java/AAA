package com.devtiro.database.controllers;

import com.devtiro.database.domain.dto.BookDto;
import com.devtiro.database.domain.entities.BookEntity;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
import java.util.Optional;
import java.util.Optional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Collections;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final Mapper<BookEntity, BookDto> bookMapper;

    public BookController(Mapper<BookEntity, BookDto> bookMapper, BookService bookService) {
        this.bookMapper = bookMapper;
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity savedBookEntity = bookService.createUpdateBook(bookEntity.getIsbn(), bookEntity);
        BookDto savedBookDto = bookMapper.mapTo(savedBookEntity);

        return new ResponseEntity<>(savedBookDto, HttpStatus.CREATED);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<BookDto> createUpdateBook(@PathVariable String isbn, @RequestBody BookDto bookDto) {
        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        boolean bookExists = bookService.isExists(isbn);
        BookEntity savedBookEntity = bookService.createUpdateBook(isbn, bookEntity);
        BookDto savedUpdatedBookDto = bookMapper.mapTo(savedBookEntity);

        return new ResponseEntity<>(savedUpdatedBookDto, bookExists ? HttpStatus.OK : HttpStatus.CREATED);
    }

    @PatchMapping("/{isbn}")
    public ResponseEntity<BookDto> partialUpdateBook(
            @PathVariable String isbn,
            @RequestBody BookDto bookDto
    ) {
        if (!bookService.isExists(isbn)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        BookEntity bookEntity = bookMapper.mapFrom(bookDto);
        BookEntity updatedBookEntity = bookService.partialUpdate(isbn, bookEntity);
        return new ResponseEntity<>(
                bookMapper.mapTo(updatedBookEntity),
                HttpStatus.OK);
    }

    @GetMapping
    public List<BookDto> listBooks() {
        List<BookEntity> books = bookService.findAll();
        return books.stream()
                .map(bookMapper::mapTo)
                .collect(Collectors.toList());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDto> getBook(@PathVariable String isbn) {
        Optional<BookEntity> foundBook = bookService.findOne(isbn);
        return foundBook.map(bookEntity -> {
            BookDto bookDto = bookMapper.mapTo(bookEntity);
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        bookService.delete(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{isbn}/rate")
    public ResponseEntity<?> addRating(@PathVariable String isbn, @RequestBody Map<String, Long> requestBody) {
        // 从请求体中获取评分值
        Long rating = requestBody.get("rating");

        // 检查评分是否在有效范围（0到10之间）
        if (rating < 0 || rating > 10) {
            return new ResponseEntity<>("Invalid rating. Must be between 0 and 10.", HttpStatus.BAD_REQUEST);
        }

        // 通过 BookService 查找指定 ISBN 的书籍
        Optional<BookEntity> optionalBook = bookService.findOne(isbn);
        if (optionalBook.isPresent()) {
            // 如果书籍存在，获取书籍实体并添加评分
            BookEntity bookEntity = optionalBook.get();
            bookService.addRating(isbn,rating);

            // 使用 BookMapper 将 BookEntity 转换为 BookDto
            BookDto bookDto = bookMapper.mapTo(bookEntity);

            // 返回包含 BookDto 的 ResponseEntity，表示操作成功
            return new ResponseEntity<>(bookDto, HttpStatus.OK);
        } else {
            // 如果书籍不存在，返回包含错误消息的 ResponseEntity，表示未找到书籍
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/{isbn}/rate/statistic")
    public ResponseEntity<Map<Integer, Long>> getRatingStatistics(@PathVariable String isbn) {
        Optional<BookEntity> optionalBook = bookService.findOne(isbn);
        if (optionalBook.isPresent()) {
            BookEntity bookEntity = optionalBook.get();
            Map<Integer, Long> ratingStatistics = bookEntity.getRatingStatistics();

            return new ResponseEntity<>(ratingStatistics, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Collections.emptyMap(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{isbn}/rate/average")
    public ResponseEntity<Double> getAverageRating(@PathVariable String isbn) {
        Optional<BookEntity> optionalBook = bookService.findOne(isbn);
        if (optionalBook.isPresent()) {
            BookEntity bookEntity = optionalBook.get();
            double averageRating = bookEntity.getAverageRating();

            return new ResponseEntity<>(averageRating, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
