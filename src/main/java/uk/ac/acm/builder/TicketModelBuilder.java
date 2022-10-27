package uk.ac.acm.builder;

import java.util.Date;

import uk.ac.acm.data.model.TicketModel;
import uk.ac.acm.utils.Utils;


public class TicketModelBuilder <SELF extends TicketModelBuilder<SELF>> {
	
	private TicketModel model;
	
	public TicketModelBuilder() {
		this.model = new TicketModel();
		model.setTime(new Date().getTime());
	}
	
	public SELF name(String value)
	{
		if(!Utils.IS_EMPTY(value))
			model.setName(value);
		
		return self();
	}
	
	public SELF email(String value)
	{
		if(!Utils.IS_EMPTY(value))
			model.setEmail(value);
		
		return self();
	}
	public SELF requesterId(Long value)
	{
		if(!Utils.IS_EMPTY(value))
			model.setRequestId(value);
		
		return self();
	}


	@SuppressWarnings("unchecked")
	protected SELF self()
	{
		return (SELF) this;
	}
	
	public TicketModel build()
	{
		
		return model;
	}


}
