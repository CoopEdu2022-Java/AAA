package com.devtiro.database.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_id_seq")
    private Long id;

    private String name;

    private Integer age;

    private String tag; // Added for personalized tags

    // Getter and setter for 'tag'

    // Assuming you have a getter and setter for 'books'
    @OneToMany(mappedBy = "authorEntity", cascade = CascadeType.ALL)
    private List<BookEntity> books;

    public String getName() {
        return this.name;
    }

    // Existing code...
}
