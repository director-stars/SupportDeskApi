package uk.ac.acm.controller.advice;

import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import uk.ac.acm.controller.exception.ValidatorException;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleContentNotAllowedException(WebRequest request, NullPointerException exception) {
        
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
	@ExceptionHandler(ValidatorException.class)
    public ResponseEntity<Object> handleValidatorException(WebRequest request, ValidatorException exception) {
        
        return new ResponseEntity<>(exception.getErrors(), HttpStatus.FORBIDDEN);
    }
	@ExceptionHandler(NotReadablePropertyException.class)
    public ResponseEntity<Object> handleNotReadablePropertyException(WebRequest request, NotReadablePropertyException exception) {
        
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.FORBIDDEN);
    }
}
