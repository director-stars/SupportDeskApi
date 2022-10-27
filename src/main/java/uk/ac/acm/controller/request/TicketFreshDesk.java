package uk.ac.acm.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketFreshDesk {

	private String name;
	private String email;
	private Long requester_id;
	private String type = TYPE.QUESTION.getValue();
	private String subject;
	private String description;
	private Long email_config_id;
	private String[] cc_emails;
	//private String company_id;
//	private Integer source = SOURCE.PORTAL.getValue();
	private Integer source = 1;
	private Integer status = STATUS.OPEN.getValue();
	private Integer priority = PRIORITY.MEDIUM.getValue();

	public enum PRIORITY{

		LOW(1),MEDIUM(2), HIGH(3),URGENT(4);

		private final Integer value;
		private PRIORITY(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}
	
	public enum STATUS{

		OPEN(2),PENDING(3), RESOLVED(4),CLOSED(5);

		private final Integer value;
		private STATUS(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}
	public enum SOURCE{

		EMAIL(2),PORTAL(3), CHAT(4),PHONE(5),MOBIHELP(6),OUTBOUNDEMAIL(6),FEEDBACKWIDGET(6);

		private final Integer value;
		
		private SOURCE(Integer value) {
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}
	}
}
