package com.springBootRedisAsDB.Redis.Exception;

import com.springBootRedisAsDB.Redis.Exception.StudentIdAlreadyPresentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentIdAlreadyPresentException.class)
    public ResponseEntity<String> handleGlobalExceptionHandler(StudentIdAlreadyPresentException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(StudentIdNotAvailableException.class)
    public ResponseEntity<String> handleStudentIdNotAvailableException(StudentIdNotAvailableException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(DatabaseIsEmptyException.class)
    public ResponseEntity<String> handleDatabaseIsEmptyException(DatabaseIsEmptyException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


}
