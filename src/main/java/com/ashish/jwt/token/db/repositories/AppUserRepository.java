package com.ashish.jwt.token.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.jwt.token.db.model.CactusUser;

@Component
public interface AppUserRepository extends CrudRepository <CactusUser, Long>{

	CactusUser findByUserName(String username);
}
