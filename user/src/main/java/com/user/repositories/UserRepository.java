package com.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByEmail(String email);

}
