package com.devtiro.database.repositories;

import com.devtiro.database.domain.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, String>,
        PagingAndSortingRepository<BookEntity, String> {

    Optional<BookEntity> findByIsbn(String isbn);


    List<BookEntity> findByAuthorEntity_Id(Long authorId);

    // Add more custom query methods if needed
}
