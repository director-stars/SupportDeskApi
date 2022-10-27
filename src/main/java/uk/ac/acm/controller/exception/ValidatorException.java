package uk.ac.acm.controller.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@SuppressWarnings("serial")
public class ValidatorException  extends Exception {
	private static Map<String, String> errorsMessage = new HashMap<>();
	public ValidatorException(String message, BindingResult result) {
		super(getMessage(result));
		error(result);
	}
	public ValidatorException(BindingResult result) {
		super(getMessage(result));
		error(result);
	}
	private void error(BindingResult result) {
		for (Object object : result.getAllErrors()) {
			if(object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;
				errorsMessage.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
		}
	}
	private static String getMessage(BindingResult result) {
		try {
			for (int i = 0; i < result.getAllErrors().size(); i++) {
				Object obj = result.getAllErrors().get(i);
				if(obj instanceof FieldError) {
					FieldError fieldError = (FieldError) obj;
					return  fieldError.getDefaultMessage();
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "Invalid input";
	}
	public Map<String, String> getErrors() {
		return errorsMessage;
	}
	public void setErrors(Map<String, String> errors) {
		this.errorsMessage = errors;
	}



}
