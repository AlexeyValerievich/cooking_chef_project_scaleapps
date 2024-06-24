package ru.evgen.cooking_chef_project.error;

import jakarta.persistence.EntityNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.evgen.cooking_chef_project.dto.for_error.ErrorDto;


import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ErrorDto> handleExceptionGroup(){
        return ResponseEntity
                .status(400)
                .header("Exception Group", "0")
                .body(new ErrorDto(400,"Вы ввели не существующий ID группы студентов"));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ErrorDto> handleExceptionStudent(){
        return ResponseEntity
                .status(400)
                .header("Exception Student", "0")
                .body(new ErrorDto(400,"Вы ввели не существующий ID студента"));
    }

}
 //EntityNotFoundException
