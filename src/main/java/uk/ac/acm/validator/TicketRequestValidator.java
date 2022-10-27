package uk.ac.acm.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import uk.ac.acm.controller.request.Ticket;

@Service
public class TicketRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Ticket.class.equals(clazz.getClass());
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Ticket request = (Ticket) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name","name is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "type","type is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email","email is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "message","message is requred");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject","subject is requred");
		
	}

}
