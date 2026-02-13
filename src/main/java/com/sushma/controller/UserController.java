package com.sushma.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sushma.dto.UserRequest;
import com.sushma.dto.UserResponse;
import com.sushma.entity.User;
import com.sushma.repository.UserRepository;
import com.sushma.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
  private final UserRepository repo;
  private final UserService userService;

  public UserController(UserService userService ,UserRepository repo) {
      this.repo = repo;
	this.userService = userService;
  }

	/*
	 * public UserController(UserRepository repo) { this.repo = repo; }
	 */
		/*
		 * @PostMapping public ResponseEntity<UserResponse> createUser(
		 * 
		 * @RequestBody UserRequest request) {
		 * 
		 * UserResponse response = userService.createUser(request); return
		 * ResponseEntity.ok(response); }
		 */
  

        @PostMapping("/user")
        public Object createUser(@Valid @RequestBody User user) {
            repo.save(user);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "SUCCESS");
            response.put("message", "User created successfully");
            response.put("requestId", UUID.randomUUID().toString());

            return response;
        }
    
        
        @GetMapping("/users")
        public ResponseEntity<Page<UserResponse>> getUsers(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "5") int size,
                @RequestParam(defaultValue = "userId") String sortBy) {

            return ResponseEntity.ok(userService.getUsers(page, size, sortBy));
        }


}
