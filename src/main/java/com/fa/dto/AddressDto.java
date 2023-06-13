package com.fa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AddressDto {

	private String id;

	private String address;

	@JsonIgnore
	private NewDto user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public NewDto getUser() {
		return user;
	}

	public void setUser(NewDto user) {
		this.user = user;
	}

}
