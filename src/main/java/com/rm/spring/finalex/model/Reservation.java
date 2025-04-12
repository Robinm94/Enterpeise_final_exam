package com.rm.spring.finalex.model;

import java.util.Date;

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
public class Reservation {
	@Id
	private String reservationId;
	private String ticketNumber;
	private String status;
	private Date reservationDateTime = new Date(System.currentTimeMillis());
	
	public Reservation() {
		super();
	}
	public Reservation(String ticketNumber, String status) {
		super();
		this.ticketNumber = ticketNumber;
		this.status = status;
		this.setReservationDateTime(new Date(System.currentTimeMillis()));
	}
	public Reservation(String reservationId, String ticketNumber, String status, Date reservationDateTime) {
		super();
		this.reservationId = reservationId;
		this.ticketNumber = ticketNumber;
		this.status = status;
		this.setReservationDateTime(reservationDateTime);
	}
	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getReservationDateTime() {
		return reservationDateTime;
	}
	public void setReservationDateTime(Date reservationDateTime) {
		this.reservationDateTime = reservationDateTime;
	}

}
