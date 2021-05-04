package com.pbd.sertaoprotocolo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/protocolos")
public class ProtocoloController {

    @GetMapping("/listar")
    public String listarFuncionario() {
        return "protocolo/listar_protocolo";
    }

}
