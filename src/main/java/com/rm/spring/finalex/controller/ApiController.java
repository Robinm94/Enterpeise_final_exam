package com.rm.spring.finalex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/airline-tickets")
	public String getAllAirlineTickets() throws JsonProcessingException {
	    List<AirlineTicket> tickets = airlineTicketService.getAllTickets().collectList().block();
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(tickets);
	}

	@GetMapping("/airline-tickets/{ticketId}")
	public String getAirlineTicketById(@PathVariable String ticketId) throws JsonProcessingException {
	    AirlineTicket ticket = airlineTicketService.getTicketById(ticketId).block();
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(ticket);
	}

	@GetMapping("/customers")
	public String getAllCustomers() throws JsonProcessingException {
	    List<Customer> customers = customerService.getAllCustomers().collectList().block();
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(customers);
	}

	@GetMapping("/customers/{customerId}")
	public String getCustomerById(@PathVariable String customerId) throws JsonProcessingException {
	    Customer customer = customerService.getCustomerById(customerId).block();
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(customer);
	}

	@GetMapping("/reservations")
	public String getAllReservations() throws JsonProcessingException {
	    List<Reservation> reservations = reservationService.getAllReservations().collectList().block();
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(reservations);
	}

	@GetMapping("/reservations/{reservationId}")
	public String getReservationById(@PathVariable String reservationId) throws JsonProcessingException {
	    Reservation reservation = reservationService.getReservationById(reservationId).block();
	    ObjectMapper objectMapper = new ObjectMapper();
	    return objectMapper.writeValueAsString(reservation);
	}
	
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
