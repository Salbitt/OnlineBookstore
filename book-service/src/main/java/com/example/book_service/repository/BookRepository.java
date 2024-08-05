package com.example.book_service.repository;

import com.example.book_service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {


    public Optional<Book> findBookByTitle(String title);

    public List<Book> findBooksByGenre(String genre);

    @Query("SELECT b from Book b WHERE b.price between :price1 AND :price2")
    public List<Book> findBooksWithinRange(@Param("price1") Double price1, @Param("price2") Double price2);


}


