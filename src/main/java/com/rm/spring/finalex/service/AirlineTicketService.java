package com.rm.spring.finalex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.spring.finalex.model.AirlineTicket;
import com.rm.spring.finalex.repository.AirlineTicketRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AirlineTicketService {
	@Autowired
	private AirlineTicketRepository airlineTicketRepository;

	public Mono<AirlineTicket> createTicket(AirlineTicket ticket) {
		return airlineTicketRepository.save(ticket);
	}

	public Flux<AirlineTicket> getAllTickets() {
		return airlineTicketRepository.findAll();
	}

	public Mono<AirlineTicket> getTicketById(String id) {
		return airlineTicketRepository.findById(id);
	}

	public Mono<AirlineTicket> updateTicket(String id, AirlineTicket updatedTicket) {
		return airlineTicketRepository.findById(id).flatMap(existing -> {
			updatedTicket.setTicketId(id);
			return airlineTicketRepository.save(updatedTicket);
		});
	}
	
	public double calculateTotalPrice(int numberofTickets) {
		return numberofTickets * 100.0;
	}	

	public Mono<Void> deleteTicket(String id) {
		return airlineTicketRepository.deleteById(id);
	}
}
