package com.example.javabased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

	@Bean
	Chinese getChinese() {
		return new Chinese();
	}

	@Bean
	Indian getIndian() {
		return new Indian();
	}

	@Bean
	@Primary
	Italian getItalian() {
		return new Italian();
	}

	@Bean
	Waiter getWaiter() {
		Waiter waiter = new Waiter();
		waiter.setMenuItems(getChinese());
		return waiter;
	}
}
