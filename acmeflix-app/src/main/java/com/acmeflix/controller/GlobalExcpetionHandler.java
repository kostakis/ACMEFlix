package com.acmeflix.controller;

import com.acmeflix.base.AbstractLogComponent;
import com.acmeflix.transfer.ApiError;
import com.acmeflix.transfer.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExcpetionHandler extends AbstractLogComponent {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleException(final Exception ex, final WebRequest webRequest) {
        logger.error("An unexpected exception was thrown.", ex);

        ApiError apiError = new ApiError();
        apiError.setStatus(500);
        apiError.setMessage(ex.getMessage());
        apiError.setPath(webRequest.getDescription(false));


        return new ResponseEntity(ApiResponse.<String>builder()
                .apiError(apiError)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<?> handleNotFoundException(final Exception ex, final WebRequest webRequest) {
        //ex.printStackTrace();
        logger.error("Exception handleNotFoundException thrown: " + ex.getMessage());

        ApiError apiError = new ApiError();
        apiError.setStatus(404);
        apiError.setMessage(ex.getMessage());
        apiError.setPath(webRequest.getDescription(false));


        return new ResponseEntity(ApiResponse.<String>builder()
                .apiError(apiError)
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<?> handleNotFoundException(final IllegalArgumentException ex, WebRequest webRequest) {
        //ex.printStackTrace();
        logger.error("Exception IllegalArgumentException thrown: " + ex.getMessage());

        ApiError apiError = new ApiError();
        apiError.setStatus(400);
        apiError.setMessage(ex.getMessage());
        apiError.setPath(webRequest.getDescription(false));

        return new ResponseEntity(ApiResponse.<String>builder()
                .apiError(apiError)
                .build(), HttpStatus.BAD_REQUEST);
    }

}
