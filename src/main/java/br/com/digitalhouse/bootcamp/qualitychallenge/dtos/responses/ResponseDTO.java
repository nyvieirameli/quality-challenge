package br.com.digitalhouse.bootcamp.qualitychallenge.dtos.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

public class ResponseDTO<T> {

    @JsonIgnore
    private HttpStatus httpStatus;

    private Long timestamp;
    private Boolean hasError;
    private String errorMessage;
    private T data;

    public ResponseDTO(T data) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
        this.hasError = false;
    }

    public ResponseDTO(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.timestamp = System.currentTimeMillis();
        this.hasError = true;
        this.errorMessage = errorMessage;
        this.data = null;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean isHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
