package com.example.book_service.controller;

import com.example.book_service.payload.BookDTO;
import com.example.book_service.payload.BookListingDTO;
import com.example.book_service.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/books/")
public class BookController {


    @Autowired
    private BookService bookService;

    @GetMapping
    public String sendMessage()
    {
        return "Hello from book service";
    }

    @GetMapping("/listings")
    public ResponseEntity<List<BookListingDTO>> getBookListings()
    {
        return new ResponseEntity<>(bookService.getBookListings(), HttpStatus.OK);
    }

    @PostMapping("/add-book")
    public ResponseEntity<BookDTO> addBookToList(@RequestBody @Valid BookDTO bookDTO)
    {
        return new ResponseEntity<>(bookService.addBook(bookDTO),HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<BookDTO> getBookDetails(@RequestParam Long id)
    {
        return new ResponseEntity<>(bookService.getBookDetails(id),HttpStatus.OK);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<BookListingDTO>> getBooksByGenre(@RequestParam String genre)
    {
        return new ResponseEntity<>(bookService.findBooksByGenre(genre),HttpStatus.OK);
    }

    @GetMapping("/find-within/")
    public ResponseEntity<List<BookListingDTO>> getBooksWithinRange(@RequestParam Double price1, @RequestParam Double price2)
    {
        return new ResponseEntity<>(bookService.findBooksWithinRange(price1,price2),HttpStatus.OK);
    }

    @GetMapping("/title")
    public ResponseEntity<BookListingDTO> getBookByTitle(@RequestParam String title)
    {
        return new ResponseEntity<>(bookService.findBookByTitle(title),HttpStatus.OK);
    }

    @PutMapping("/update-stock/")
    public ResponseEntity<BookDTO> updateBookStock(@RequestParam Long id, @RequestParam Long stock)
    {
        return new ResponseEntity<>(bookService.updateBookStockById(id, stock),HttpStatus.OK);
    }

    @DeleteMapping("/delete-book/")
    public ResponseEntity<BookDTO> deleteBook(@RequestParam Long id)
    {
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
    }

}
