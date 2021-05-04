package com.pbd.sertaoprotocolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/listar")
    public String listUser(){
        return "user/listar_user";
    }

}
