package com.registration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	//	@formatter:off
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
   	  		httpSecurity
   	  			.csrf(CsrfConfigurer<HttpSecurity>::disable)
   	  			.authorizeHttpRequests((authorizeHttpRequests) ->
   	  				authorizeHttpRequests
   	  					.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/users/register")).permitAll()
   	  			);
    // @formatter:on

		return httpSecurity.build();
	}

}
