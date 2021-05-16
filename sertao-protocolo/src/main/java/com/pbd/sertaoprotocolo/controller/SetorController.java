package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Setor;
import com.pbd.sertaoprotocolo.service.InstituicaoService;
import com.pbd.sertaoprotocolo.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService setorService;
    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping("/listar")
    public ModelAndView listSetor() {
        ModelAndView view = new ModelAndView();
        view.addObject("setores", setorService.getSetors());
        view.setViewName("setor/setor_list");
        return view;
    }

    @GetMapping("/new_setor")
    public ModelAndView createSetor(Setor setor) {
        ModelAndView view = new ModelAndView();
        view.addObject("instituicoes", instituicaoService.getInstituicaos());
        view.setViewName("setor/setor_form");
        return view;
    }

    @RequestMapping(value = "/new_setor", method = RequestMethod.POST)
    public ModelAndView registerSetor(@Valid Setor setor, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        setor.setNome(setor.getNome().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("setor/setor_form");
        }
        setorService.createSetor(setor);
        modelAndView.addObject("successMessage", "Setor registrado com sucesso");
        modelAndView.setViewName("redirect:/setores/listar");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createSetor(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Setor setor = setorService.getSetor(id);
        view.addObject("setor", setor);
        view.addObject("instituicoes", instituicaoService.getInstituicaos());
        view.setViewName("setor/setor_form");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateSetor(@Valid Setor setor, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        setor.setNome(setor.getNome().toUpperCase());

        if (result.hasErrors()) {
            modelAndView.setViewName("setor/setor_form");
        }
        setorService.createSetor(setor);
        modelAndView.addObject("successMessage", "Setor registrado com sucesso");
        modelAndView.setViewName("redirect:/setores/listar");
        return modelAndView;
    }
}
