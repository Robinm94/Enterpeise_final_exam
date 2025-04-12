package com.rm.spring.finalex.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rm.spring.finalex.model.AirlineTicket;

@Repository
public interface AirlineTicketRepository extends ReactiveMongoRepository<AirlineTicket, String> {

}
