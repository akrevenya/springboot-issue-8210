package com.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@EnableWebSecurity
@RestController
public class DemoApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DemoApplication.class)
				.properties("server.port=8080","management.port=8000","management.security.enabled=false")
				.run(args);
	}

	@RequestMapping(value="/")
	public String index() {
		return "I am Secured content";
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers( "/**").authenticated()
				.anyRequest().permitAll()
		;

	}
}
