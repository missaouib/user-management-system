package com.nafisulbari.ums.security;

import com.nafisulbari.ums.entity.User;

public interface UserService {

    void save(User user);

    User findByUserId(String userId);

}
