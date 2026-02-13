package com.sushma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sushma.entity.User;

public interface UserRepository extends JpaRepository<User, String>  {

}
