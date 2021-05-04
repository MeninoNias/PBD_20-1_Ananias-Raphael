package com.pbd.sertaoprotocolo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcinarios")
public class FuncionarioController {

    @GetMapping("/listar")
    public String listarFuncionario() {
        return "funcionario/listar_funcionario";
    }

}
