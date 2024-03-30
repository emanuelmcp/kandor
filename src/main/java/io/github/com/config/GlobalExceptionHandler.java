package io.github.com.config;

import io.github.com.dto.common.ErrorDTO;
import io.github.com.exceptions.*;
import io.github.com.utils.DateUtil;
import org.jetbrains.annotations.NotNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicatedAttributesException.class)
    public ResponseEntity<ErrorDTO> handleDuplicatedAttributesException(@NotNull DuplicatedAttributesException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
                ErrorDTO
                        .builder()
                        .message(e.getMessage())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleEntityAlreadyExistsException(@NotNull EntityAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(
                ErrorDTO
                        .builder()
                        .message(e.getMessage())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(EntityAssociationException.class)
    public ResponseEntity<ErrorDTO> handleEntityAssociationException(@NotNull EntityAssociationException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
                ErrorDTO
                        .builder()
                        .message(e.getMessage())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleEntityNotFoundException(@NotNull EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
                ErrorDTO
                        .builder()
                        .message(e.getMessage())
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorDTO> handleNotAuthorizedException(@NotNull UnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(
                ErrorDTO
                    .builder()
                    .message(e.getMessage())
                    .date(DateUtil.getZuluDate())
                    .build()
        );
    }

    @ExceptionHandler(EntityUpdateException.class)
    public ResponseEntity<ErrorDTO> handleEntityUpdateException(@NotNull EntityUpdateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
            ErrorDTO
                .builder()
                .message(e.getMessage())
                .date(DateUtil.getZuluDate())
                .build()
        );
    }

    // Internal exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(@NotNull MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(
                ErrorDTO
                        .builder()
                        .message("Error de validacion")
                        .date(DateUtil.getZuluDate())
                        .build()
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ErrorDTO> handleNoResourceFoundException(@NotNull NoResourceFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(
            ErrorDTO
                .builder()
                .message("No se ha podido encontrar la ruta")
                .date(DateUtil.getZuluDate())
                .build()
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> handleDataIntegrityViolationException(@NotNull DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
            ErrorDTO
                .builder()
                .message("Error desconocido. Contacta con soporte")
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
