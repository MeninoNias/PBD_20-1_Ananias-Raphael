package com.pbd.sertaoprotocolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcinarios")
public class FuncionarioController {

    @GetMapping("/listar")
    public String listFuncionario() {
        return "funcionario/listar_funcionario";
    }

    @GetMapping("/new_func")
    public String createFuncionario() {
        return "funcionario/form_funcionario";
    }

}
