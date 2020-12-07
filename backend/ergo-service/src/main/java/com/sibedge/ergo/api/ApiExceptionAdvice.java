package com.sibedge.ergo.api;

import java.util.List;
import java.util.stream.Collectors;

import com.sibedge.ergo.shared.transport.ErrorData;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
class ApiExceptionAdvice extends ResponseEntityExceptionHandler {

    /**
     * {@inheritDoc}
     *
     * <p>Converts validation violations to the standardized error output.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException cause,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<String> errors = cause.getBindingResult().getFieldErrors().stream()
                .map(error -> String.join(": ", error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        cause.getBindingResult().getGlobalErrors().stream()
                .map(error -> String.join(": ", error.getObjectName(), error.getDefaultMessage()))
                .collect(Collectors.toCollection(() -> errors));

        headers.setContentType(MediaType.APPLICATION_JSON);
        return handleExceptionInternal(cause, ErrorData.of(errors), headers, HttpStatus.BAD_REQUEST, request);
    }

}
