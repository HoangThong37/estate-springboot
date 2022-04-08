package com.laptrinhjavaweb.controllerAdvisor;

import com.laptrinhjavaweb.dto.reponse.ErrorReponse;
import com.laptrinhjavaweb.exception.FieldRequireException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FieldRequireException.class)
    public ResponseEntity<ErrorReponse>  handleCityNotFoundException(FieldRequireException ex, WebRequest request) {
        ErrorReponse result = new ErrorReponse();
        result.setError("Field is require");
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        result.setDetail(details);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
