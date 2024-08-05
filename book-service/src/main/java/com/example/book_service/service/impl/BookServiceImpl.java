package com.example.book_service.service.impl;

import com.example.book_service.entity.Book;
import com.example.book_service.payload.BookDTO;
import com.example.book_service.payload.BookListingDTO;
import com.example.book_service.repository.BookRepository;
import com.example.book_service.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookServiceImpl implements BookService {


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    Logger logger = Logger.getLogger("Logger");

    public BookDTO mapToDTO(Book book)
    {
        return modelMapper.map(book,BookDTO.class);
    }

    public Book mapToEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

    public BookListingDTO mapToListingDTO(BookDTO bookDTO)
    {
        return new BookListingDTO(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getGenre(), bookDTO.getPrice(), bookDTO.getDescription());
    }


    @Override
    public List<BookListingDTO> getBookListings() {

        try
        {
            List<Book> books = bookRepository.findAll();
            List<BookDTO> bookDTOS =  books.stream().map(this::mapToDTO).toList();
            return bookDTOS.stream().map(this::mapToListingDTO).toList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) {

        try {
            Book book = mapToEntity(bookDTO);
            System.out.println(book);
            Book book1 = bookRepository.save(book);
            System.out.println(book1);

            return modelMapper.map(book1,BookDTO.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public BookDTO getBookDetails(Long id) {

       Optional<Book> optional = bookRepository.findById(id);
        return optional.map(this::mapToDTO).orElse(null);
    }

    @Override
    public BookListingDTO findBookByTitle(String title) {
        Optional<Book> optional = bookRepository.findBookByTitle(title);

        BookDTO bookDTO =  optional.map(this::mapToDTO).orElse(null);

        if(bookDTO!=null)
            return mapToListingDTO(bookDTO);

        return null;
    }

    @Override
    public List<BookListingDTO> findBooksByGenre(String genre) {

        List<Book> bookList = bookRepository.findBooksByGenre(genre);

       List<BookDTO> bookDTOS =  bookList.stream().map(this::mapToDTO).toList();

       return bookDTOS.stream().map(this::mapToListingDTO).toList();
    }

    @Override
    public List<BookListingDTO> findBooksWithinRange(Double price1, Double price2) {
        List<Book> bookList = bookRepository.findBooksWithinRange(price1,price2);

        List<BookDTO> bookDTOS =  bookList.stream().map(this::mapToDTO).toList();

        return bookDTOS.stream().map(this::mapToListingDTO).toList();
    }

    @Override
    public BookDTO updateBookStockById(Long id, Long stock) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isPresent())
        {
            Book book = optional.get();
            book.setStock(stock);
            bookRepository.save(book);
            return mapToDTO(book);
        }
        return null;
    }

    @Override
    public BookDTO deleteBook(Long id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isPresent())
        {
            Book book = optional.get();
            bookRepository.delete(book);
            return mapToDTO(book);
        }
        return null;
    }


}
