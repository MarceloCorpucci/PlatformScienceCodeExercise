package com.example.domain;

import com.example.helper.CustomLogger;

public class Destination {
	private String address;
	private boolean evenChars;
	private boolean isAssigned;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		CustomLogger.showInfo("Addres: " + address);
	}
	
	public boolean hasEvenChars() {
		return this.evenChars;
	}
	
	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssignation(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	public void defineAdressCharAmountParity() {
		if(this.address.length() % 2 == 0) { 
			this.evenChars = true;
		} else {
			this.evenChars = false;
		}
		CustomLogger.showInfo("Is even: " + this.evenChars);
	}
}
