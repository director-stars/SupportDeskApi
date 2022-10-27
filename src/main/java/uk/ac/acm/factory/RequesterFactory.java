package uk.ac.acm.factory;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uk.ac.acm.controller.request.Ticket;
import uk.ac.acm.data.model.TicketModel;
import uk.ac.acm.repo.service.TicketRepoService;
import uk.ac.acm.utils.Utils;
@Service
@AllArgsConstructor
public class RequesterFactory {
	
	private final TicketRepoService ticketRepoService;
	public FreshDesk get(final Ticket request) {
		
		if(Utils.IS_EMPTY(request)) {
			throw new NullPointerException("Ticket cant be empty");
		}
		
		TicketModel data = ticketRepoService.findByEmail(request.getEmail());
		if(Utils.IS_EMPTY(data)) 
			return new NewRequester(request);
		else 
			return new ExistingRequester(request,data);
	}
}
