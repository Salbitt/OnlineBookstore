package com.example.book_service.service;

import com.example.book_service.payload.BookDTO;
import com.example.book_service.payload.BookListingDTO;

import java.util.List;

public interface BookService {

    public List<BookListingDTO> getBookListings();

    public BookDTO addBook(BookDTO bookDTO);

    public BookDTO getBookDetails(Long id);

    public BookListingDTO findBookByTitle(String title);

    public List<BookListingDTO> findBooksByGenre(String genre);

    public List<BookListingDTO> findBooksWithinRange(Double price1, Double price2);

    public BookDTO updateBookStockById(Long id, Long stock);

    public BookDTO deleteBook(Long id);




}
