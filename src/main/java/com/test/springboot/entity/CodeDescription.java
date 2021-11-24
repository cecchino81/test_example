package com.test.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeDescription {

    private String code;
    private String description;
        
    
	public CodeDescription() {
		super();
	}


	public CodeDescription(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "CodeDescription [code=" + code + ", description=" + description + "]";
	}
  
    
    
}
