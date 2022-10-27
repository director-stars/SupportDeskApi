package uk.ac.acm.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Acm_Ticket_Email_Config")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter @Setter
public class EmailConfigModel {
	
	@Id
	private int Id;
	@Column(name = "`SupportTitle`" )
	private String supportTitle;
	@Column(name = "`Location`" )
	private String location;
	private String SupportEmail;
	private Long EmailConfigId;
}
