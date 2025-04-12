package com.rm.spring.finalex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rm.spring.finalex.model.Reservation;
import com.rm.spring.finalex.repository.ReservationRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReservationService {
	@Autowired
	private ReservationRepository reservationRepository;

	public Mono<Reservation> createReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	public Flux<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}

	public Mono<Reservation> getReservationById(String id) {
		return reservationRepository.findById(id);
	}

	public Mono<Reservation> updateReservation(String id, Reservation updatedReservation) {
		return reservationRepository.findById(id).flatMap(existing -> {
			updatedReservation.setReservationId(id);
			return reservationRepository.save(updatedReservation);
		});
	}

	public Mono<Void> deleteReservation(String id) {
		return reservationRepository.deleteById(id);
	}
}
