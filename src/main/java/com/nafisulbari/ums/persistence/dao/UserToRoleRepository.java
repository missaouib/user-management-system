package com.nafisulbari.ums.persistence.dao;

import com.nafisulbari.ums.persistence.model.UserToRole;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserToRoleRepository extends CrudRepository<UserToRole, Integer> {
}
