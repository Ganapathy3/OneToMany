package com.fa.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class NewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinTable(name = "user_role_mapping", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private List<RoleEntity> role;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL, })
	@JoinTable(name = "user_branch_mapping", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "branch_id") })
	private List<BranchEntity> branch;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AddressEntity> address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<RoleEntity> getRole() {
		return role;
	}

	public void setRole(List<RoleEntity> role) {
		this.role = role;
	}

	public List<BranchEntity> getBranch() {
		return branch;
	}

	public void setBranch(List<BranchEntity> branch) {
		this.branch = branch;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEntity> address) {
		this.address = address;
	}

}
