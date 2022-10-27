package uk.ac.acm.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@ConfigurationProperties(prefix="uk.ac.acm.freshdesk")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class FreshDeskConfig {
	
	@NotNull
	private String createTicket = "tickets";
	@NotNull
	private String root;
	@NotNull
	private String key;
}
