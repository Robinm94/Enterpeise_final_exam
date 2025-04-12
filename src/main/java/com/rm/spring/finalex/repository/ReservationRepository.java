package com.rm.spring.finalex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rm.spring.finalex.model.Reservation;

@Repository
public interface ReservationRepository extends ReactiveMongoRepository<Reservation, String> {

}
