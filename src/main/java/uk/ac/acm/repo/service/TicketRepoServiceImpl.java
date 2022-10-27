package uk.ac.acm.repo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uk.ac.acm.builder.TicketModelBuilder;
import uk.ac.acm.controller.request.TicketFreshDesk;
import uk.ac.acm.controller.request.TicketFreshDeskResponse;
import uk.ac.acm.data.model.TicketModel;
import uk.ac.acm.data.repo.TicketModelRepo;
import uk.ac.acm.utils.Utils;

@Service
@AllArgsConstructor
public class TicketRepoServiceImpl implements TicketRepoService{

	private final TicketModelRepo repo;
	
	@Override
	@Cacheable(cacheNames = "TicketRepoServiceImplFindByEmail",unless="#result!=null")
	public TicketModel findByEmail(String email) {
		
		if(Utils.IS_EMPTY(email)) {
			throw new NullPointerException("Student email cannot be empty");
		}
		
		return repo.findTicketModelByEmail(email);
		
	}

	@Override
	public TicketModel insert(TicketFreshDeskResponse response, TicketFreshDesk freshDesk) {
		TicketModel model = new TicketModelBuilder<>()
				.name(freshDesk.getName())
				.email(freshDesk.getEmail())
				.requesterId(response.getRequester_id())
				.build();
		return repo.save(model);
	}
	
	
}
