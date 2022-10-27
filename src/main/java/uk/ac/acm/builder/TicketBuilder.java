package uk.ac.acm.builder;

import uk.ac.acm.controller.request.TYPE;
import uk.ac.acm.controller.request.TicketFreshDesk;
import uk.ac.acm.data.model.TicketModel;
import uk.ac.acm.utils.Utils;


public class TicketBuilder <SELF extends TicketBuilder<SELF>> {
	
	private TicketFreshDesk freshDesk;
	private TicketModel model;
	
	public TicketBuilder(TicketModel model) {
		this.model = model;
		this.freshDesk = new TicketFreshDesk();
		this.freshDesk.setRequester_id(model.getRequestId());
	}
	
	public TicketBuilder() {
		this.freshDesk = new TicketFreshDesk();
	}
	
	public SELF name(String value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setName(value);
		
		return self();
	}
	
	
	public SELF email(String value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setEmail(value);
		
		return self();
	}
	public SELF cc_email(String[] value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setCc_emails(value);
		
		return self();
	}
	public SELF subject(String value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setSubject(value);
		
		return self();
	}
	public SELF type(String value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setType(TYPE.TASK.getValue());
		
		return self();
	}
	public SELF description(String value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setDescription(value);
		
		return self();
	}
	
	public SELF email_config_id(Long value)
	{
		if(!Utils.IS_EMPTY(value))
			freshDesk.setEmail_config_id(value);
		
		return self();
	}
	@SuppressWarnings("unchecked")
	protected SELF self()
	{
		return (SELF) this;
	}
	
	public TicketFreshDesk build()
	{
		
		return freshDesk;
	}


}
