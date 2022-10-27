package uk.ac.acm.service;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
import uk.ac.acm.config.FreshDeskConfig;
import uk.ac.acm.controller.request.Ticket;
import uk.ac.acm.controller.request.TicketFreshDesk;
import uk.ac.acm.controller.request.TicketFreshDeskResponse;
import uk.ac.acm.data.model.EmailConfigModel;
import uk.ac.acm.data.model.StudentModel;
import uk.ac.acm.data.repo.EmailConfigModelRepo;
import uk.ac.acm.data.repo.StudentModelRepo;
import uk.ac.acm.data.repo.TicketModelRepo;
import uk.ac.acm.factory.FreshDesk;
import uk.ac.acm.factory.RequesterFactory;

import uk.ac.acm.repo.service.TicketRepoService;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{

	private final WebClient client;
	private final RequesterFactory factory;
	private final FreshDeskConfig freshDeskConfig;
	private final TicketRepoService ticketRepoService;
	private final ObjectMapper mapper;
	
	private final TicketModelRepo repo;
	private final StudentModelRepo studentRepo;
	private final EmailConfigModelRepo emailConfigRepo;

	public String findLocation(String text)
	{
		String location = "guildford";
		if(text.contains("london"))
			location = "london";
		if(text.contains("guildford"))
			location = "guildford";
		if(text.contains("birmingham"))
			location = "birmingham";
		return location;
	}
	
	@Override
	public Object create(final Ticket ticket) throws IOException {
		

		StudentModel studentData = studentRepo.findStudentModelByEmail(ticket.getEmail());
		System.out.println(studentData);
		String location = "guildford";
		if(studentData != null)
			location = studentData.getRecentCourse() != null ?findLocation(studentData.getRecentCourse().toLowerCase()) : "guildford";
		EmailConfigModel emailConfigData = emailConfigRepo.findEmailConfigModelBySupportTitleAndLocation(ticket.getSubject() , location);
		
		ticket.setEmail_config_id(emailConfigData.getEmailConfigId());
		
		FreshDesk freshDesk = factory.get(ticket);
        TicketFreshDesk desk = freshDesk.create();
              
		
        System.out.println(desk);
		//Send data to freshdesk api
        try {
        Mono<Object> data = client.post().uri(freshDeskConfig.getRoot()+freshDeskConfig.getCreateTicket())
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(freshDesk.create()), TicketFreshDesk.class)
				.exchange()
				.block()
				.bodyToMono(Object.class);
        
        //Convert the request to a response model       
        
		TicketFreshDeskResponse response = mapper.convertValue(data.block(), TicketFreshDeskResponse.class);
		if(!freshDesk.exist()) {
			ticketRepoService.insert(response,desk);
		}
		return response;
        }
        catch (Exception ex){
        	return "please try again";
        }
	}
	
	@Override
	public Object get(String id){
		return client.get().uri(freshDeskConfig.getRoot()+freshDeskConfig.getCreateTicket()+"/"+id).exchange().block()
				.bodyToMono(Object.class);

	}
}
