package com.ashish.jwt.token.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.jwt.token.db.model.User;

@Component
public interface AppUserRepository extends CrudRepository <User, Long>{

	User findByUserName(String username);
}
