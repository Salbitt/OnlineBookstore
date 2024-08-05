package com.example.book_service.payload;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class ErrorDTO {

    private int errorCode;

    private String message;
}
