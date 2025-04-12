package com.rm.spring.finalex.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	@NotBlank(message = "Ticket number is required")
	private String ticketNumber;

	@NotBlank(message = "Status is required")
	@Pattern(regexp = "^(CONFIRMED|PENDING|CANCELLED)$", message = "Status must be CONFIRMED, PENDING, or CANCELLED")
	private String status;

	@NotNull(message = "Reservation date and time is required")
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
