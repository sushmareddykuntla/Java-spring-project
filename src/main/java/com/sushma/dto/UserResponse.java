package com.sushma.dto;

public class UserResponse {

	private String status;
    private String message;
    private String requestId;
    private String userId;
    private String name;
    private String email;
	public UserResponse(String userId, String name, String email) {
		this.userId=userId;
		this.name=name;
		this.email=email;
	}
	
	public UserResponse() {
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}
