package com.devtiro.database.domain.entities;

import com.devtiro.database.services.BookService;

import com.devtiro.database.repositories.BookRepository;

import com.devtiro.database.domain.dto.BookDto;
import com.devtiro.database.domain.entities.BookEntity;
import com.devtiro.database.mappers.Mapper;
import com.devtiro.database.services.BookService;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")

public class BookEntity {


    @Id
    private String isbn;

    private String title;

    private List<Long> ratings;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;

     public double getAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0; // or throw an exception, depending on your application logic
        }

        long sum = 0;
        for (Long rating : ratings) {
            sum += rating;
        }

        return (double) sum / ratings.size();
    }




    public Map<Integer, Long> getRatingStatistics() {
        if (ratings == null || ratings.isEmpty()) {
            return Collections.emptyMap();
        }

        // Calculate rating statistics
        Map<Integer, Long> ratingStatistics = new HashMap<>();
        for (Long rating : ratings) {
            int ratingValue = rating.intValue();

            // Increment the count for the rating value
            ratingStatistics.merge(ratingValue, 1L, Long::sum);
        }

        return ratingStatistics;
    }


    public void addRating(Long rating) {
        log.info("Adding rating: {}", rating);

        // 如果 ratings 为 null，初始化为一个新的 ArrayList
        if (ratings == null) {
            ratings = new ArrayList<>();
        }

        ratings.add(rating);

        // 保存更新后的实体到数据库
        // 注意：这里假设你有一个 BookRepository，用于保存 BookEntity 实体
        // 如果没有，请根据你的实际情况注入或获取 BookRepository

    }


    public BookEntity(String isbn, String title, List<Long> ratings, AuthorEntity authorEntity) {
        this.isbn = isbn;
        this.title = title;
        this.ratings = new ArrayList<>();
        this.authorEntity = authorEntity;
    }


    private static final Logger log = LoggerFactory.getLogger(BookEntity.class);

}

