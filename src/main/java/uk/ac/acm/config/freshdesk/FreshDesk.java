package uk.ac.acm.config.freshdesk;

import java.util.Collections;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import uk.ac.acm.config.FreshDeskConfig;
@Configuration
@EnableConfigurationProperties({FreshDeskConfig.class})
@AllArgsConstructor
public class FreshDesk {
	private final FreshDeskConfig freshDeskConfig;
	@Bean
	public WebClient webclient() {
		WebClient client = WebClient
				  .builder()
				    .baseUrl(freshDeskConfig.getRoot())
				    .defaultHeaders(header -> header.setBasicAuth(freshDeskConfig.getKey(), ""))
				    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
				    .defaultUriVariables(Collections.singletonMap("url", freshDeskConfig.getRoot()))
				  .build();
		return client;
	}

}
