package com.rm.spring.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rm.spring.finalex.model.AirlineTicket;
import com.rm.spring.finalex.model.Customer;
import com.rm.spring.finalex.model.Reservation;
import com.rm.spring.finalex.service.AirlineTicketService;
import com.rm.spring.finalex.service.CustomerService;
import com.rm.spring.finalex.service.ReservationService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private AirlineTicketService airlineTicketService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ReservationService reservationService;

	@PostMapping("/airline-tickets")
	public String createAirlineTicket(@RequestBody AirlineTicket airlineTicket) throws JsonProcessingException {
		AirlineTicket ticket = airlineTicketService.createTicket(airlineTicket).block();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(ticket);
		return jsonString;
	}

	@PostMapping("/customers")
	public String createCustomer(@RequestBody Customer customer) throws JsonProcessingException {
		Customer createdCustomer = customerService.addCustomer(customer).block();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(createdCustomer);
		return jsonString;
	}

	@PostMapping("/reservations")
	public String createReservation(@RequestBody Reservation reservation) throws JsonProcessingException {
		Reservation createdReservation = reservationService.createReservation(reservation).block();
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(createdReservation);
		return jsonString;
	}

	@PutMapping("/airline-tickets")
	public String updateAirlineTicket(@RequestBody AirlineTicket airlineTicket) throws JsonProcessingException {
		AirlineTicket updatedTicket = airlineTicketService.updateTicket(airlineTicket.getTicketId(),airlineTicket).block();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(updatedTicket);
	}

	@PutMapping("/customers")
	public String updateCustomer(@RequestBody Customer customer) throws JsonProcessingException {
		Customer updatedCustomer = customerService.updateCustomer(customer.getCustomerId(),customer).block();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(updatedCustomer);
	}

	@PutMapping("/reservations")
	public String updateReservation(@RequestBody Reservation reservation) throws JsonProcessingException {
		Reservation updatedReservation = reservationService.updateReservation(reservation.getReservationId(),reservation).block();
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(updatedReservation);
	}

}
