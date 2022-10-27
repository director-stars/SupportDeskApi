package uk.ac.acm.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import uk.ac.acm.builder.TicketBuilder;
import uk.ac.acm.controller.request.Ticket;
import uk.ac.acm.controller.request.TicketFreshDesk;

@AllArgsConstructor
@Data
public class NewRequester implements FreshDesk {
	
	private final Ticket ticket;
	
	@Override
	public TicketFreshDesk create() {
		
		return new TicketBuilder<>()
				.description(this.ticket.getMessage())
				.subject(this.ticket.getSubject()+ ": "+this.ticket.getName())
				.email(this.ticket.getEmail())
				.cc_email(new String[] {})
//				.cc_email(new String[] {"samson.odubanjo@gorillaict.com","mev@gorillaict.com"})
				.type(this.ticket.getSubject())
				.name(this.ticket.getName())
				.email_config_id(this.ticket.getEmail_config_id())
				.build();
	}

	 
	@Override
	public Boolean exist() {
		// TODO Auto-generated method stub
		return false;
	}

}
