package com.learningRest.MTI.DTO.RequestDTO;



public class PostCreationRequestDTO {

	private String title;
	private String body;
	private String userId;

	
	//default constructor
	public PostCreationRequestDTO() {

	}

	//parameterized constructor
	public PostCreationRequestDTO(String title, String body, String userId) {
		super();
		this.title = title;
		this.body = body;
		this.userId = userId;
	}

	
	//getters & Setters
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
