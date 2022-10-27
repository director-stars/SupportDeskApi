package uk.ac.acm.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketFreshDeskResponse {

	private Long requester_id;
	private Long id;
	
}
