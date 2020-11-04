package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Address;
import dmacc.beans.Voter;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Voter voter() {
		Voter bean = new Voter("Logan Harvey");
		return bean;
	}
	
	@Bean
	public Address address() {
		Address bean = new Address("666 Gov Street", "West Des Moines", "IA");
		return bean;
	}
}
