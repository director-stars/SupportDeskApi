package uk.ac.acm.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket {
	
	private String email;
	private String subject; 
	private String name;
	private String message; 
	private String type; 
	private Long email_config_id;
}
