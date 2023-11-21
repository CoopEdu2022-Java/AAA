package com.devtiro.database.services.impl;
import com.devtiro.database.domain.dto.AuthorDto;

import com.devtiro.database.domain.entities.AuthorEntity;
import com.devtiro.database.domain.entities.BookEntity;
import com.devtiro.database.repositories.AuthorRepository;
import com.devtiro.database.repositories.BookRepository;
import com.devtiro.database.services.AuthorService;
import com.devtiro.database.domain.dto.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.devtiro.database.mappers.Mapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private Mapper<AuthorEntity, AuthorDto> authorMapper;

    private BookRepository bookRepository;
    private BookMapper bookMapper; // Assuming you have a BookMapper, add this line

    @Autowired
    public AuthorServiceImpl(
            AuthorRepository authorRepository,
            BookRepository bookRepository
             // Assuming you have a BookMapper, add this line
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
 // Assuming you have a BookMapper, add this line
    }

    @Override
    public AuthorEntity save(AuthorEntity authorEntity) {
        return authorRepository.save(authorEntity);
    }

    @Override
    public List<AuthorEntity> findAll() {
        return StreamSupport.stream(authorRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AuthorEntity> findOne(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public boolean isExists(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public AuthorEntity partialUpdate(Long id, AuthorEntity authorEntity) {
        authorEntity.setId(id);

        return authorRepository.findById(id).map(existingAuthor -> {
            Optional.ofNullable(authorEntity.getName()).ifPresent(existingAuthor::setName);
            Optional.ofNullable(authorEntity.getAge()).ifPresent(existingAuthor::setAge);
            return authorRepository.save(existingAuthor);
        }).orElseThrow(() -> new NotFoundException("Author does not exist"));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    public void addTagToAuthor(Long authorId, String tag) {
        AuthorEntity author = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Author not found"));
        // Check if the tag already exists
        if (author.getTag() != null && author.getTag().equals(tag)) {
            // Tag already exists, increment count
            // You might want to add a separate member for count if needed
            // For simplicity, let's just update the tag for now
            author.setTag(tag);
        } else {
            // Tag doesn't exist, set it to the new tag
            author.setTag(tag);
        }
        authorRepository.save(author);
    }

    public List<String> getTagsForAuthor(Long authorId) {
        AuthorEntity author = authorRepository.findById(authorId).orElseThrow(() -> new NotFoundException("Author not found"));
        return List.of(author.getTag());
    }

    public List<BookDto> getBooksByAuthorId(Long authorId) {
        List<BookEntity> books = bookRepository.findByAuthorEntity_Id(authorId);
        return books.stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public AuthorEntity getAuthorById(Long authorId) {
        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(authorId);
        return authorEntityOptional.orElse(null); // 或者抛出异常或其他适当的处理方式
    }


    // 添加 BookMapper 接口
    public interface BookMapper {
        BookDto toDto(BookEntity bookEntity);
    }

    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }
}
