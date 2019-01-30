package com.ashish.jwt.token.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.jwt.token.db.model.RoleMaster;

@Component
public interface AppRoleRepository extends CrudRepository <RoleMaster, Long>{

	RoleMaster findByRoleName(String rolename);
}
