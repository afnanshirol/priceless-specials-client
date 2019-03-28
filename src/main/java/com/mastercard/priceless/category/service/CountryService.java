package com.mastercard.priceless.category.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.mastercard.priceless.category.model.CategoryResponse;
import com.mastercard.priceless.common.AuthorizationUtil;

@Service
public class CountryService {
	
	@Autowired
	RestTemplate restTemplate;
	/**
	 * @param queryParam 
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<String> getCountries(String queryParam) throws Exception{
		String authHeader = AuthorizationUtil.getAuthorizationHeader("countries",queryParam);
		
		System.out.println(authHeader);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", authHeader);
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		
		ResponseEntity<String> response = restTemplate.exchange("https://sandbox.api.mastercard.com/priceless/specials/v1/countries"+queryParam, HttpMethod.GET, entity, String.class);
		return response;
	}


}
