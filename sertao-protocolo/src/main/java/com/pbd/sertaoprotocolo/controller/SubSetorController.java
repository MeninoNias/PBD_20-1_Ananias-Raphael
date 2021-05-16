package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.SubSetor;
import com.pbd.sertaoprotocolo.service.InstituicaoService;
import com.pbd.sertaoprotocolo.service.SetorService;
import com.pbd.sertaoprotocolo.service.SubSetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/subsetores")
public class SubSetorController {

    @Autowired
    private SubSetorService lotacaoService;
    @Autowired
    private SetorService setorService;

    @GetMapping("/listar")
    public ModelAndView listSubSetor() {
        ModelAndView view = new ModelAndView();
        view.addObject("lotacaoes", lotacaoService.getSubSetors());
        view.setViewName("lotacao/lotacao_list");
        return view;
    }

    @GetMapping("/new_lotacao")
    public ModelAndView createSubSetor(SubSetor subSetor) {
        ModelAndView view = new ModelAndView();
        view.addObject("setores", setorService.getSetors());
        view.setViewName("lotacao/lotacao_form");
        return view;
    }

    @RequestMapping(value = "/new_lotacao", method = RequestMethod.POST)
    public ModelAndView registerSubSetor(@Valid SubSetor subSetor, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        subSetor.setNome(subSetor.getNome().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("lotacao/lotacao_form");
        }
        lotacaoService.createSubSetor(subSetor);
        modelAndView.addObject("successMessage", "SubSetor registrado com sucesso");
        modelAndView.setViewName("redirect:/subsetores/listar");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createSubSetor(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        SubSetor subSetor = lotacaoService.getSubSetor(id);
        view.addObject("subSetor", subSetor);
        view.addObject("setores", setorService.getSetors());
        view.setViewName("lotacao/lotacao_form");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateSubSetor(@Valid SubSetor subSetor, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        subSetor.setNome(subSetor.getNome().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("lotacao/lotacao_form");
        }
        lotacaoService.createSubSetor(subSetor);
        modelAndView.addObject("successMessage", "SubSetor registrado com sucesso");
        modelAndView.setViewName("redirect:/subsetores/listar");
        return modelAndView;
    }
}
