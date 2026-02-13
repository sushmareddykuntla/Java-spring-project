package com.sushma.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserRequest {
	
    @NotBlank(message = "UserId is mandatory")
	 private String userId;
    
    @NotBlank(message = "UserId is mandatory")
	    private String name;
    
    @NotBlank(message = "UserId is mandatory")
    @Email(message = "Invalid email format")
	    private String email;
    
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
