package com.sushma.service;

import org.springframework.data.domain.Page;

import com.sushma.dto.UserRequest;
import com.sushma.dto.UserResponse;

public interface UserService {

	UserResponse createUser(UserRequest request);
	Page<UserResponse> getUsers(int page, int size, String sortBy);

	
}
