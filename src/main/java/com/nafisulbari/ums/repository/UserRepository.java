package com.nafisulbari.ums.repository;

import com.nafisulbari.ums.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int userId);

}
