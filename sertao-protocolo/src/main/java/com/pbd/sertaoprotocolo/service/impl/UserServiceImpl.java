package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.export.UserExport;
import com.pbd.sertaoprotocolo.model.Role;
import com.pbd.sertaoprotocolo.model.SubSetor;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.repository.RoleRepository;
import com.pbd.sertaoprotocolo.repository.UserRepository;
import com.pbd.sertaoprotocolo.service.UserService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserExport userExport;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findByAtivoBanco(true);
    }

    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles((Set<Role>) new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User u) {
        User user = findById(u.getId());
        user.setAtivoBanco(false);
        updateUser(user);
        return user;
    }

    @Override
    public XSSFWorkbook exportExel() {

        userExport = new UserExport();
        userExport.exelCabelcalho();
        userExport.popularLinhas(getUsers());

        return userExport.getWorkbook();

    }
}
