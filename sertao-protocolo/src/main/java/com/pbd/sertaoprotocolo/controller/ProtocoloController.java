package com.pbd.sertaoprotocolo.controller;


import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/protocolos")
public class ProtocoloController {

    @GetMapping("/listar")
    public String listarProtocolos() {
        return "protocolo/listar_protocolo";
    }

    @GetMapping("/my_protocol")
    public ModelAndView listarMeusProtocolos(){
        ModelAndView view = new ModelAndView();

        view.setViewName("protocolo/listar_protocolo");
        return view;
    }

}
