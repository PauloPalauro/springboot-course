package com.palauro.coursespring.Resources.exceptions;

import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.palauro.coursespring.Services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

// Tratamento manual para os errors.

// @ControllerAdvice = Vai interceptar para que ele possa executar um possivel tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // Capaz de interceptar a requisição que deu exceção para cair nessa função. (X) -> Nome da exceção a ser interceptada.
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) { 
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND; // 404 não achou
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI()); // request.getRequestURI = caminho da requisição.
        return ResponseEntity.status(status).body(err); // ResponseEntity.status(status) = retorna uma resposta com codigo personalizado.
    }

}
