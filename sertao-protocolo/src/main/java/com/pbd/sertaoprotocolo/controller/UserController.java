package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.repository.RoleRepository;
import com.pbd.sertaoprotocolo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/listar")
    public ModelAndView listUser(){
        ModelAndView view = new ModelAndView();
        view.addObject("users", userService.getUsers());
        view.setViewName("user/listar_user");
        return view;
    }
    @GetMapping("/update/{id}")
    public ModelAndView listUser(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("user/user_update");
        User user = userService.findById(id);
        mv.addObject("user", user);
        mv.addObject("use_roles", roleRepository.findAll());
        return mv;
    }

}
