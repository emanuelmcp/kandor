package io.github.com.exceptions.handlers;

import io.github.com.exceptions.Error;
import io.github.com.exceptions.enums.ExceptionCodes;
import io.github.com.exceptions.errors.*;
import io.github.com.utils.DateUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicatedAttributesException.class)
    public ResponseEntity<Error> handleDuplicatedAttributesException(@NotNull DuplicatedAttributesException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
                Error
                        .builder()
                        .errorCode(ExceptionCodes.NOT_FOUND.getCode())
                        .message(e.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Error> handleEntityAlreadyExistsException(@NotNull EntityAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(
                Error
                        .builder()
                        .errorCode(ExceptionCodes.ALREADY_EXISTS.getCode())
                        .message(e.getMessage())
                        .status(HttpStatus.CONFLICT.value())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(EntityAssociationException.class)
    public ResponseEntity<Error> handleEntityAssociationException(@NotNull EntityAssociationException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
                Error
                        .builder()
                        .errorCode(ExceptionCodes.NOT_FOUND.getCode())
                        .message(e.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleEntityNotFoundException(@NotNull EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
                Error
                        .builder()
                        .errorCode(ExceptionCodes.NOT_FOUND.getCode())
                        .message(e.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Error> handleNotAuthorizedException(@NotNull UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(
                Error
                    .builder()
                    .errorCode(ExceptionCodes.UNAUTHORIZED.getCode())
                    .message(e.getMessage())
                    .status(HttpStatus.UNAUTHORIZED.value())
                    .date(DateUtil.getZuluDate())
                    .build()
        );
    }


    // Internal exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleMethodArgumentNotValidException(@NotNull MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(
                Error
                        .builder()
                        .errorCode(e.getClass().toString())
                        .message("Error de validacion")
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }
}


/*
protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                              HttpHeaders headers, HttpStatus status, WebRequest request) {

    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) ->{

        String fieldName = ((FieldError) error).getField();
        String message = error.getDefaultMessage();
        errors.put(fieldName, message);
    });
    return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
}*/
