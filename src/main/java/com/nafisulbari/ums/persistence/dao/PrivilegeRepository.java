package com.nafisulbari.ums.persistence.dao;

import com.nafisulbari.ums.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
}
