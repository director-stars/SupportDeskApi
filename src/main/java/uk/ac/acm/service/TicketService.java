package uk.ac.acm.service;

import java.io.IOException;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uk.ac.acm.controller.request.Ticket;
import uk.ac.acm.controller.request.TicketFreshDesk;

public interface TicketService {

	Object create(Ticket ticket) throws IOException;

	Object get(String id);

	
}
