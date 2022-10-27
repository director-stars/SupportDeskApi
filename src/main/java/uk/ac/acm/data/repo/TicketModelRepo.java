package uk.ac.acm.data.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.ac.acm.data.model.TicketModel;

public interface TicketModelRepo extends JpaRepository<TicketModel, String> {

	TicketModel findTicketModelByEmail(String email);

	
}
