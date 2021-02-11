package com.nafisulbari.ums.persistence.dao;

import com.nafisulbari.ums.persistence.model.RoleToPrivilege;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleToPrivilegeRepository extends CrudRepository<RoleToPrivilege, Integer> {
}
