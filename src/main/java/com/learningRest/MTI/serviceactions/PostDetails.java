package com.learningRest.MTI.serviceactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningRest.MTI.DTO.RequestDTO.PostCreationRequestDTO;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDetails {

	RequestSpecification ReqSpec;
	Response response;

	ObjectMapper mapper = new ObjectMapper();

	// RestAssured
	// RequestSpecification, Response

	public void testGetRequestForPostDetails(String postID) {

		ReqSpec = RestAssured.given();

		// set the headers
		List<Header> header = new ArrayList<Header>();
		header.add(new Header("Content-Type", "application/json"));
		Headers headers = new Headers(header);
		ReqSpec.headers(headers);

		// hit the get request
		response = ReqSpec.get("https://jsonplaceholder.typicode.com/posts/" + postID);
		System.out.println(response.asString());
		System.out.print(response.getStatusCode());

	}

	public int getResponseStatusCode() {
		return response.getStatusCode();
	}

	public void testPostRequest(Map<String, String> requestBody) throws JsonProcessingException {

		ReqSpec = RestAssured.given();

		// set the headers -> Step 1
		List<Header> header = new ArrayList<Header>();
		header.add(new Header("Content-Type", "application/json"));
		Headers headers = new Headers(header);
		ReqSpec.headers(headers);

		// Request Create
		PostCreationRequestDTO request = new PostCreationRequestDTO(requestBody.get("title"), requestBody.get("body"),
				requestBody.get("userId"));
		
		System.out.println(request);
		
		
		String body = mapper.writeValueAsString(request);
		ReqSpec.body(body);

		response = ReqSpec.post("https://jsonplaceholder.typicode.com/posts");

		System.out.println(response.asString());
		System.out.print(response.getStatusCode());

	}

	public void AsssertResponse() {

		
		
	}

}
