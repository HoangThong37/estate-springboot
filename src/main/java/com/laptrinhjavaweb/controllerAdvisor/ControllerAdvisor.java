package com.laptrinhjavaweb.controllerAdvisor;

import com.laptrinhjavaweb.dto.ErrorReponse;
import com.laptrinhjavaweb.exception.FieldRequireException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

/*    @ExceptionHandler(FieldRequireException.class)
    public ReponseEntity<ErrorReponse>  handleCityNôtFoundException(FieldRequireException ex, WebRequest request) {
        ErrorReponse result = new ErrorReponse();
        result.setError("Field is require");
        List<String> details = new ArrayList<>();
        details.add(ex.getMessage());
        result.setDetail(details);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

}
