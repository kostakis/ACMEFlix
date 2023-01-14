package com.acmeflix.controller;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.transfer.ApiError;
import com.acmeflix.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExcpetionHandler extends AbstractLogComponent {

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<?> handleNotFoundException(final Exception ex) {
        //ex.printStackTrace();
        logger.error("Exception handleNotFoundException thrown: " + ex.getMessage());

        ApiError apiError = new ApiError();
        apiError.setStatus(404);
        apiError.setMessage(ex.getMessage());
        apiError.setPath(null);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setApiError(apiError);

        return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<?> handleNotFoundException(final IllegalArgumentException ex) {
        //ex.printStackTrace();
        logger.error("Exception IllegalArgumentException thrown: " + ex.getMessage());

        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setMessage(ex.getMessage());
        apiError.setPath(null);

        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setApiError(apiError);

        return new ResponseEntity<ApiResponse<String>>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
