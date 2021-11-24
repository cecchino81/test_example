package com.test.springboot.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Saldo {

    private String status;
    private String[] error;
    private Payload payload;
        
	public Saldo() {
		super();
	}
	public Saldo(String status, Payload payload) {
		super();
		this.status = status;
		this.payload = payload;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String[] getError() {
		return error;
	}
	public void setError(String[] error) {
		this.error = error;
	}

	public Payload getPayload() {
		return payload;
	}
	public void setPayload(Payload payload) {
		this.payload = payload;
	}
	@Override
	public String toString() {
		return "Saldo [status=" + status + ", error=" + Arrays.toString(error) + ", payload=" + payload + "]";
	}
    
}
