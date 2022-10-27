package uk.ac.acm.repo.service;

import uk.ac.acm.controller.request.TicketFreshDesk;
import uk.ac.acm.controller.request.TicketFreshDeskResponse;
import uk.ac.acm.data.model.TicketModel;

public interface TicketRepoService {

	TicketModel findByEmail(String email);

	TicketModel insert(TicketFreshDeskResponse response, TicketFreshDesk freshDesk);

	
}
