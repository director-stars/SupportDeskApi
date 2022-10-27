package uk.ac.acm.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "acm_ticket_model")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class TicketModel {
	
	@Id
	private String email;
	private Long requestId;
	private String name;
	private Long time;
}
