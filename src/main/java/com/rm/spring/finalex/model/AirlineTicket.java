package com.rm.spring.finalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Document
@ToString
public class AirlineTicket {
	@Id
	private String ticketId;
	private String number;
	private int numberOfSeats;
	private String details;
	private String ticketClass;
	private double price;
	
	public AirlineTicket() {
		super();
	}
	public AirlineTicket(String number, int numberOfSeats, String details, String ticketClass , double price) {
		super();
		this.number = number;
		this.details = details;
		this.price = price;
		this.ticketClass = ticketClass;
		this.setNumberOfSeats(numberOfSeats);
	}
	public AirlineTicket(String ticketId, String number, int numberOfSeats, String details, String ticketClass , double price) {
		super();
		this.ticketId = ticketId;
		this.number = number;
		this.details = details;
		this.price = price;
		this.ticketClass = ticketClass;
		this.setNumberOfSeats(numberOfSeats);
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTicketClass() {
		return ticketClass;
	}
	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}
	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	
}
