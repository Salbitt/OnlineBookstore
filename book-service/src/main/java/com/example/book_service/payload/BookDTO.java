package com.example.book_service.payload;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {


    private Long id;

    @NotNull(message = "The title should not be null")
    @NotEmpty(message = "The title cannot be empty")
    private String title;

    @NotNull(message = "The author name should not be null")
    @NotEmpty(message = "The author name cannot be empty")
    @Pattern(regexp = "[a-z A-Z]+")
    private String author;

    @NotNull(message = "The genre should not be null")
    @NotEmpty(message = "The genre cannot be empty")
    private String genre;

    @NotNull(message = "The price should not be null")
    @Positive(message = "The price must be positive")
    private Double price;

    @NotNull(message = "The description should not be null")
    @NotEmpty(message = "The description cannot be empty")
    private String description;

    @NotNull(message = "The stock should not be null")
    @Positive(message = "The stock must be a valid integer")
    private Long stock;

}
