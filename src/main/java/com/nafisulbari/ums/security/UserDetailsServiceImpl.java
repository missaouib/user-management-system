package com.nafisulbari.ums.security;

import com.nafisulbari.ums.persistence.model.RoleToPrivilege;
import com.nafisulbari.ums.persistence.model.User;
import com.nafisulbari.ums.persistence.model.UserToRole;
import com.nafisulbari.ums.persistence.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUserId(Integer.parseInt(username));



        if (user == null) throw new UsernameNotFoundException(username);

        System.out.println("ServiceImpl"+" : "+user.getPassword());

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserToRole userToRole : user.getUserToRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getRole().getName()));

            for (RoleToPrivilege roleToPrivilege : userToRole.getRole().getRoleToPrivileges()) {
                authorities.add(new SimpleGrantedAuthority(roleToPrivilege.getPrivilege().getUrl()));
            }

        }


        return new CustomUserDetails(user, authorities);

    }
}
