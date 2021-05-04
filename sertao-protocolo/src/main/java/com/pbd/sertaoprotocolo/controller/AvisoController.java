package com.pbd.sertaoprotocolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/avisos")
public class AvisoController {

    @GetMapping("/listar")
    public String listAvisos() {
        return "aviso/listar_aviso";
    }

    @GetMapping("/new_aviso")
    public String createAvisos(){
        return "aviso/form_aviso";
    }

}
