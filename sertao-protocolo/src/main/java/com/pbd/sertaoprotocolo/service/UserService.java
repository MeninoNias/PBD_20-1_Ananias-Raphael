package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String s);
    User findById(Long id);
    List<User> getUsers();
    User findUserByUserName(String userName);
    User saveUser(User user);

}
