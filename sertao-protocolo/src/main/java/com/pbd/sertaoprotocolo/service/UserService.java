package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.User;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.List;

public interface UserService {

    User findUserByEmail(String s);
    User findById(Long id);
    List<User> getUsers();
    User findUserByUserName(String userName);
    User saveUser(User user);
    User updateUser(User user);

    XSSFWorkbook exportExel();

}
