package com.nafisulbari.ums.persistence.dao;
import com.nafisulbari.ums.persistence.model.RoleToPrivilege;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface RoleToPrivilegeRepository extends CrudRepository<RoleToPrivilege, Integer> {

    @Transactional
    void deleteDistinctByRoleIdAndPrivilegeId(Integer roleId, Integer privilegeId);
}
