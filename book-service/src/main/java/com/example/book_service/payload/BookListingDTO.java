package com.example.book_service.payload;

//title, author, genre, price, and description.

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookListingDTO {

    private String title;

    private String author;

    private String genre;

    private Double price;

    private String description;

}
