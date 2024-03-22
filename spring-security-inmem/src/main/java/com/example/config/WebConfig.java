package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import ch.qos.logback.core.encoder.Encoder;

@Configuration
@EnableWebSecurity 
public class WebConfig {

	// two beans
	//Authentication using inmemory authentication
	@Bean
	public UserDetailsManager userDetails() {
		UserDetails user1=
				User.withUsername("Kus")
					.password(encoder().encode("123"))
					.roles("ADMIN","USER")
					.build();
		
		UserDetails user2=
				User.withUsername("Bas")
					.password(encoder().encode("bas123"))
					.roles("USER")
					.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Authorization bean
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception{
		//authorize http requests based on roles
		//Implement Customer functional interface
		
		
		return http
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests((auth)->auth
						.requestMatchers("/api/user/**").hasAnyRole("ADMIN","USER")
						.requestMatchers("/api/admin/**").hasRole("ADMIN")
						.anyRequest().authenticated()
						)
				.sessionManagement(sess-> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.httpBasic(Customizer.withDefaults())
				.build();
		
		
		
		
	}
}
