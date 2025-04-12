package com.rm.spring.finalex.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rm.spring.finalex.dto.FormDataDTO;
import com.rm.spring.finalex.model.AirlineTicket;
import com.rm.spring.finalex.model.Customer;
import com.rm.spring.finalex.model.Reservation;

@Controller
@RequestMapping("/")
public class ClientController {

	@Autowired
    private ApiController apiController;
	
	@Autowired
    private ObjectMapper objectMapper;


	@GetMapping
	public String index() {
		return "index";
	}

	@PostMapping
	public String postForm(FormDataDTO formDataDTO, Model model) {
		 try {
	            // Create customer through API controller
	            Customer customer = new Customer(formDataDTO.getFirstName(), formDataDTO.getLastName(), null,
	                    formDataDTO.getPhone(), null, null, null);
	            String customerJson = apiController.createCustomer(customer);
	            Customer createdCustomer = objectMapper.readValue(customerJson, Customer.class);

	            // Create airline ticket through API controller
	            Random random = new Random();
	            String ticketId = String.valueOf(random.nextInt(1000000));
	            AirlineTicket airlineTicket = new AirlineTicket(ticketId, formDataDTO.getNoOfPassengers(), "Flight details",
	                    formDataDTO.getTicketClass(), 200.0);
	            String ticketJson = apiController.createAirlineTicket(airlineTicket);
	            AirlineTicket createdTicket = objectMapper.readValue(ticketJson, AirlineTicket.class);

	            // Create reservation through API controller
	            Reservation reservation = new Reservation(null, createdTicket.getTicketId(), "CONFIRMED", new Date());
	            String reservationJson = apiController.createReservation(reservation);
	            Reservation createdReservation = objectMapper.readValue(reservationJson, Reservation.class);

	            model.addAttribute("customer", createdCustomer);
	            model.addAttribute("reservation", createdReservation);
	            model.addAttribute("airlineTicket", createdTicket);

	            return "displayData";
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }
	}

}
