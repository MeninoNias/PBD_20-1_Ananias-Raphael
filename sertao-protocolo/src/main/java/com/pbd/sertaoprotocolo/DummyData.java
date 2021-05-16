package com.pbd.sertaoprotocolo;

import com.pbd.sertaoprotocolo.model.Role;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.repository.RoleRepository;
import com.pbd.sertaoprotocolo.repository.UserRepository;
import com.pbd.sertaoprotocolo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DummyData {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    RoleRepository roleRepository;

//    @PostConstruct
    public void saveUser(){

//        User user = new User();
//        user.setUserName("ananias");
//        user.setActive(true);
//        user.setPassword("ananias123");
//        user.setEmail("admin@admin.com");
//
//        userService.saveUser(user);

        Role role = new Role();
        role.setRole("USER_ADMIN");
        roleRepository.save(role);

    }

}
