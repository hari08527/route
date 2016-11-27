package com.Route21.ws.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterPartyRequest {

	@JsonProperty("NAME")
	private String name;
	
	@JsonProperty("LAST_NAME")
	private String lastName;
	
	@JsonProperty("EMAIL")
	private String email;
	
	@JsonProperty("PASSWORD")
	private String password;
	
	@JsonProperty("PARTY_TYPE")
	private int partyType;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPartyType() {
		return partyType;
	}
	public void setPartyType(int partyType) {
		this.partyType = partyType;
	}
	
}
