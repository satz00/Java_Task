package com.project.bus_ticket_booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.bus_ticket_booking.repo")
public class BusTicketBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusTicketBookingApplication.class, args);
	}

}
