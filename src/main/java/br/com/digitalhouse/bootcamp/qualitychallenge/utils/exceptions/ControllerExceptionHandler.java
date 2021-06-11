package br.com.digitalhouse.bootcamp.qualitychallenge.utils.exceptions;

import br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ResponseDTO> objectNotFound(NotFoundException e, HttpServletRequest request) {

        return ExceptionResponse(new ResponseDTO(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ResponseDTO> dataIntegrity(BadRequestException e, HttpServletRequest request) {

        return ExceptionResponse(new ResponseDTO(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    private ResponseEntity<ResponseDTO> ExceptionResponse(ResponseDTO err) {
        return ResponseEntity.status(err.getHttpStatus()).body(err);
    }
}