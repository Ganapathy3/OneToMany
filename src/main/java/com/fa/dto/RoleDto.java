package com.fa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RoleDto {

	private String id;

	private String role;

	@JsonIgnore
	private NewDto user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public NewDto getUser() {
		return user;
	}

	public void setUser(NewDto user) {
		this.user = user;
	}

}
