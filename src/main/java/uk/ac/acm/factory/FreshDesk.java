package uk.ac.acm.factory;

import uk.ac.acm.controller.request.TicketFreshDesk;

public interface FreshDesk {
	TicketFreshDesk create ();
	Boolean exist();
}
