package com.test.springboot.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Payload {

    private List<Account> listaAccount;
    
	public Payload() {
		super();
	}

	public Payload(List<Account> listaAccount) {
		super();
		this.listaAccount = listaAccount;
	}

	@JsonGetter("list")
	public List<Account> getList() {
		return listaAccount;
	}

	public void setList(List<Account> listaAccount) {
		this.listaAccount = listaAccount;
	}

	@Override
	public String toString() {
		return "Payload [listaAccount=" + listaAccount + "]";
	}
        
}
