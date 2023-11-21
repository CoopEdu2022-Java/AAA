package com.devtiro.database.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDto {

    private Long id;

    private String name;

    private Integer age;

    private List<BookDto> books;  // 此处使用了BookDto，确保导入正确

    // 其他方法和构造函数...

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
