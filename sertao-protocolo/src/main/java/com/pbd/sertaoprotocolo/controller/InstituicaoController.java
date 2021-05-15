package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Instituicao;
import com.pbd.sertaoprotocolo.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;

    @GetMapping("/listar")
    public ModelAndView listInstituicao() {
        ModelAndView view = new ModelAndView();
        view.addObject("instituicaos", instituicaoService.getInstituicaos());
        view.setViewName("instituicao/instituicao_list");
        return view;
    }

    @GetMapping("/new_instituicao")
    public ModelAndView createInstituicao(Instituicao instituicao) {
        ModelAndView view = new ModelAndView();
        view.setViewName("instituicao/instituicao_form");
        return view;
    }

    @RequestMapping(value = "/new_instituicao", method = RequestMethod.POST)
    public ModelAndView registerInstituicao(@Valid Instituicao instituicao, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        instituicao.setNome(instituicao.getNome().toUpperCase());
        Instituicao instituicaoExist = instituicaoService.getInstituicaoCNPJ(instituicao.getCnpj());
        if (instituicaoExist != null) {
            result.rejectValue("nome", "error.instituicao", "Já existe um instituicao registrado com o essa CNPJ.");
            if (result.hasErrors()) {
                modelAndView.setViewName("instituicao/instituicao_form");
            }
        } else {
            instituicaoService.createInstituicao(instituicao);
            modelAndView.addObject("successMessage", "Instituicao registrado com sucesso");
            modelAndView.addObject("instituicao", new Instituicao());
            modelAndView.setViewName("instituicao/instituicao_list");
        }
        return modelAndView;
    }
}
