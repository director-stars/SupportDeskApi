package uk.ac.acm.config;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@ConfigurationProperties(prefix="uk.ac.acm.system.datasource")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class DatabaseConfig {
	
	@NotNull
	private String jdbcurl;
	@NotNull
	private String username;
	@NotNull
	private String password;
	private String driverClassName=" com.mysql.cj.jdbc.Driver";
	private String dialect="org.hibernate.dialect.MySQL5Dialect";
	private String auto="none";
	private Boolean format = false;
	private Boolean showQuery = false;

	
}
