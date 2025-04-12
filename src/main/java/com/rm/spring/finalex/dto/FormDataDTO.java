package com.rm.spring.finalex.dto;

import lombok.Data;

@Data
public class FormDataDTO {
	private String firstName;
    private String lastName;
    private int noOfPassengers;
    private String ticketClass;
    private String phone;
    private String time;
    private String departingDate;
    
	public FormDataDTO() {
		super();
	}
	public FormDataDTO(String firstName, String lastName, int noOfPassengers, String ticketClass, String phone,
			String time, String departingDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.noOfPassengers = noOfPassengers;
		this.ticketClass = ticketClass;
		this.phone = phone;
		this.time = time;
		this.departingDate = departingDate;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getNoOfPassengers() {
		return noOfPassengers;
	}
	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	public String getTicketClass() {
		return ticketClass;
	}
	public void setTicketClass(String ticketClass) {
		this.ticketClass = ticketClass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDepartingDate() {
		return departingDate;
	}
	public void setDepartingDate(String departingDate) {
		this.departingDate = departingDate;
	}
    
    
}
