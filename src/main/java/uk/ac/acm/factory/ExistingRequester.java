package uk.ac.acm.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import uk.ac.acm.builder.TicketBuilder;
import uk.ac.acm.controller.request.Ticket;
import uk.ac.acm.controller.request.TicketFreshDesk;
import uk.ac.acm.data.model.TicketModel;
@AllArgsConstructor
@Data
public class ExistingRequester implements FreshDesk  {
	
	private final Ticket request;
	private final TicketModel ticket;
	
	@Override
	public TicketFreshDesk create() {
		
		return new TicketBuilder<>(ticket)
				.description(this.request.getMessage())
				.subject(this.request.getSubject()+ ": "+this.ticket.getName())
				.email(this.ticket.getEmail())
				.cc_email(new String[] {})
//				.email("lifeisgood91028@gmail.com")
				.type(this.request.getSubject())
				.name(this.request.getName())
				.email_config_id(this.request.getEmail_config_id())
				.build();
	}

	@Override
	public Boolean exist() {
		
		return true;
	}

}
