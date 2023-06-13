package com.fa.dto;

import java.util.List;

public class NewDto {

	private String id;

	private String userName;

	private String password;

	private List<RoleDto> role;

	private List<BranchDto> branch;

	private List<AddressDto> address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDto> getRole() {
		return role;
	}

	public void setRole(List<RoleDto> role) {
		this.role = role;
	}

	public List<BranchDto> getBranch() {
		return branch;
	}

	public void setBranch(List<BranchDto> branch) {
		this.branch = branch;
	}

	public List<AddressDto> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDto> address) {
		this.address = address;
	}

}
