package com.test.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.springboot.entity.CodeDescription;
import com.test.springboot.entity.Saldo;

@RestController
public class RestClient implements CommandLineRunner{

	public final static String GET_SALDO = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts";
	public final static String EFFETTUA_BONIFICO = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";
	public final static String AUT_SCHEMA = "S2S";
	public final static String API_KEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(RestClient.class);

	static RestTemplate restTemplate = new RestTemplate();
	

    @Override
    public void run(String... args) throws Exception {
        main(args);  
    }
	
	public static void main(String[] args) {
		getSaldo();
		effettuaBonifico();
		getTransazioni();
	}
	
	public static void getSaldo () {
				
	        HttpHeaders headers = new HttpHeaders();

			Map<String, Long> param = new HashMap<String, Long>();
			param.put("accountId", new Long(14537780));
			
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("Auth-Schemaff", AUT_SCHEMA);
	        headers.set("Api-Key", API_KEY);

	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	        try {
	        	ResponseEntity<Saldo> saldoResponse = restTemplate.exchange(GET_SALDO, HttpMethod.GET, entity, Saldo.class,param);
	        	
	        	log.info(restTemplate.toString());
	  	        System.out.println(saldoResponse.toString());
	        } catch (Exception exception) {
		        exception.getMessage();
	        }
	}
	
	public static void effettuaBonifico () {
		
        HttpHeaders headers = new HttpHeaders();

		Map<String, String> param = new HashMap<String, String>();
		param.put("accountId", "14537780");
		param.put("receiverName", "Paolo");
		param.put("description", "Bonifico Test");
		param.put("currency", "EUR");
		param.put("amount", "3500");
		param.put("executionDate", "2019-04-01");
		
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Auth-Schema", AUT_SCHEMA);
        headers.set("Api-Key", API_KEY);

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<CodeDescription> bonificoResponse = restTemplate.exchange("https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/14537780/payments/money-transfers", HttpMethod.POST, entity, CodeDescription.class,param);

        log.info(restTemplate.toString());
        System.out.println(bonificoResponse.toString());
	}
	
	public static void getTransazioni () {
		
        HttpHeaders headers = new HttpHeaders();

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("accountId", new Long(14537780));
		param.put("fromAccountingDate", "2019-01-01");
		param.put("fromAccountingDate", "2019-12-01");
			
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Auth-Schema", AUT_SCHEMA);
        headers.set("Api-Key", API_KEY);

        try {
	        HttpEntity<String> entity = new HttpEntity<String>(headers);
	        ResponseEntity<Saldo> transazioniResponse = restTemplate.exchange(GET_SALDO, HttpMethod.GET, entity, Saldo.class,param);
	        
	        log.info(restTemplate.toString());
	        System.out.println(transazioniResponse.toString());
	    } catch (Exception exception) {
	        exception.getMessage();
	    }
	}
}
