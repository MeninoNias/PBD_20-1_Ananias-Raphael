package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.service.AvisoService;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/avisos")
public class AvisoController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private AvisoService avisoService;

    @GetMapping("/listar")
    public ModelAndView listarAviso(Aviso aviso) {
        ModelAndView view = new ModelAndView();
        view.addObject("avisos", avisoService.getAvisos());
        view.setViewName("aviso/listar_aviso");
        return view;
    }

    @GetMapping("/new_aviso")
    public ModelAndView createAviso(Aviso aviso) {
        ModelAndView view = new ModelAndView();
        view.addObject("funcionariosSelect", funcionarioService.getFuncionarios());
        view.setViewName("aviso/form_aviso");
        return view;
    }

}
