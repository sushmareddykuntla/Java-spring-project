package com.sushma.service.impl;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sushma.dto.UserRequest;
import com.sushma.dto.UserResponse;
import com.sushma.exception.ValidationException;
import com.sushma.repository.UserRepository;
import com.sushma.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public Page<UserResponse> getUsers(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return repo.findAll(pageable)
                   .map(user -> new UserResponse(
                        user.getUserId(),
                        user.getName(),
                        user.getEmail()
                   ));
    }
    
	@Override
    public UserResponse createUser(UserRequest request) {

        if (request.getUserId() == null || request.getUserId().isEmpty()) {
            throw new ValidationException("USER_ID_MISSING");
        }
        
        HttpServletRequest httpRequest =
                ((ServletRequestAttributes) RequestContextHolder
                        .getRequestAttributes()).getRequest();
            String requestUUID =(String) httpRequest.getAttribute("RequestUUID");

        UserResponse response = new UserResponse();
        response.setStatus("SUCCESS");
        response.setMessage("User created successfully");
        response.setRequestId(requestUUID);

        return response;
    }
}
