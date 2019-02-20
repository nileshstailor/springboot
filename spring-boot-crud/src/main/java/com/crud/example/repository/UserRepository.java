package com.crud.example.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.example.domain.User;

public interface UserRepository extends MongoRepository<User, Serializable>{
	User findById(String id);
	
	//@Transactional
	//@Modifying
	//@Query("DELETE FROM User u WHERE u.id=?1")
	@Query( value="{id : ?1}", delete = true)
	int deleteUserById(String id);
}
