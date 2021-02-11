package com.nafisulbari.ums.persistence.dao;

import com.nafisulbari.ums.persistence.model.Role;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
