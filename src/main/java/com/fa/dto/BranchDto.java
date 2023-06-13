package com.fa.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BranchDto {

	private String id;

	private String branch;

	@JsonIgnore
	private NewDto user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public NewDto getUser() {
		return user;
	}

	public void setUser(NewDto user) {
		this.user = user;
	}

}
