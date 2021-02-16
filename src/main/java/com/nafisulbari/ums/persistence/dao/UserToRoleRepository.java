package com.nafisulbari.ums.persistence.dao;

import com.nafisulbari.ums.persistence.model.User;
import com.nafisulbari.ums.persistence.model.UserToRole;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserToRoleRepository extends CrudRepository<UserToRole, Integer> {

    @Transactional
    void deleteDistinctByUserIdAndRoleId(Integer userId, Integer roleId);

    @Transactional
    void deleteDistinctByUserId(Integer id);
}
