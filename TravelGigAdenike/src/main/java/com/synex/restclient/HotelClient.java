package com.synex.restclient;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class HotelClient {

private static final String hotelMicroServiceUrl="http://localhost:8383";
	
	public JsonNode searchHotel(JsonNode node) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(node.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(
				hotelMicroServiceUrl+ "/searchHotel",request, Object.class);
		
		Object objects = responseEntity.getBody();
		ObjectMapper mapper = new ObjectMapper();	
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

		return returnObj;
	}
	
	public JsonNode getHotelRoom(JsonNode node) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
		HttpEntity<String> request = new HttpEntity<String>(node.toString(), headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> responseEntity = restTemplate.postForEntity(
				hotelMicroServiceUrl+ "/getHotelRoom",request, Object.class);
		
		Object objects = responseEntity.getBody();
		ObjectMapper mapper = new ObjectMapper();	
		JsonNode returnObj = mapper.convertValue(objects, JsonNode.class);

		return returnObj;
	}

	
}
