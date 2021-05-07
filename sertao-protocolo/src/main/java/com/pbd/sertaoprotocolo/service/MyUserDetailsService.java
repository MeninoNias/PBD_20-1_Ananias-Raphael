package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Role;
import com.pbd.sertaoprotocolo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

public interface MyUserDetailsService {

    UserDetails loadUserByUsername(String userName);
    List<GrantedAuthority> getUserAuthority(Set<Role> userRoles);
    UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities);
}
