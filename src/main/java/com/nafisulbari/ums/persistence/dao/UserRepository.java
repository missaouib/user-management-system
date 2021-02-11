package com.nafisulbari.ums.persistence.dao;

import com.nafisulbari.ums.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int userId);

}
