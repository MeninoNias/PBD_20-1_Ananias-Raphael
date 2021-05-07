package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.User;

public interface UserService {

    User findUserByEmail(String s);
    User findUserByUserName(String userName);
    User saveUser(User user);

}
