package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public ModelAndView listUser(){
        ModelAndView view = new ModelAndView();
        view.addObject("users", userService.getUsers());
        view.setViewName("user/listar_user");
        return view;
    }

}
