package uk.ac.acm.controller;

import java.io.IOException;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import uk.ac.acm.controller.exception.ValidatorException;
import uk.ac.acm.controller.request.Ticket;
import uk.ac.acm.service.TicketService;
import uk.ac.acm.validator.TicketRequestValidator;
@RestController
@RequestMapping("acm/freshdesk")
@AllArgsConstructor
@CrossOrigin(origins="*")
public class TicketController {

	private final TicketRequestValidator ticketVAlidator;
	private final TicketService ticketService;
	@PostMapping("")
	public Object ticketPost(@RequestBody Ticket ticket,BindingResult result) throws ValidatorException, IOException {
		ticketVAlidator.validate(ticket, result);
		
		if(result.hasErrors()) {
			throw new ValidatorException(result);
		}

		return ticketService.create(ticket);
	}
	@GetMapping("")
	public Object ticketGet(@RequestParam("name") @NotBlank(message = "Name is required") @Size(min  = 1, message = "Name is required") @Size(max  = 200,  message = "Name must be lower than or equal to 200 Characters") String name,
			@RequestParam("email") @Email(message = "Email must be a valid email address") String email,
			@RequestParam("subject") @NotBlank(message = "Subject is required") @Size(min  = 1,  message = "Subject is required") @Size(max  = 200, message = "Subject must be lower than or equal to 200 Characters")  String subject,
			@RequestParam("message") @NotBlank(message = "Message is required") @Size(min  = 1, message = "Message is required")@Size(max  = 1500, message = "Message must be lower than or equal to 1500 Characters") String message) throws ValidatorException, IOException {
	
		return ticketService.create(Ticket.builder().email(email).message(message).name(name).subject(subject).build());
	}
	/*@GetMapping("/{id}")
	public Object ticket(@PathVariable String id) {

		return ticketService.get(id);
	}*/
}
