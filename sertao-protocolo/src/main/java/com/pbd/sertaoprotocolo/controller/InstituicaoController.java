package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Instituicao;
import com.pbd.sertaoprotocolo.model.UF;
import com.pbd.sertaoprotocolo.service.CidadeService;
import com.pbd.sertaoprotocolo.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

    @Autowired
    private InstituicaoService instituicaoService;
    @Autowired
    private CidadeService cidadeService;

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
        view.addObject("cidades", cidadeService.getCidades());
        view.setViewName("instituicao/instituicao_form");
        return view;
    }

    @RequestMapping(value = "/new_instituicao", method = RequestMethod.POST)
    public ModelAndView registerInstituicao(@Valid Instituicao instituicao, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        instituicao.setNome(instituicao.getNome().toUpperCase());
        Instituicao instituicaoExist = instituicaoService.getInstituicaoCNPJ(instituicao.getCnpj());
        if (instituicaoExist != null) {
            attributes.addFlashAttribute("error", "Já existe um instituicao registrado com o essa CNPJ.");
            if (result.hasErrors()) {
                modelAndView.setViewName("instituicao/instituicao_form");
            }
        } else {
            instituicaoService.createInstituicao(instituicao);
            attributes.addFlashAttribute("success", "Instituicao registrado com sucesso");
            modelAndView.setViewName("redirect:/instituicoes/listar");
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createInstituicao(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Instituicao instituicao = instituicaoService.getInstituicao(id);
        view.addObject("cidades", cidadeService.getCidades());
        view.addObject("instituicao", instituicao);
        view.setViewName("instituicao/instituicao_form");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateInstituicao(@Valid Instituicao instituicao, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        instituicao.setNome(instituicao.getNome().toUpperCase());

        if (result.hasErrors()) {
            modelAndView.setViewName("instituicao/instituicao_form");
        }
        instituicaoService.createInstituicao(instituicao);
        attributes.addFlashAttribute("success", "Instituicao registrado com sucesso");
        modelAndView.setViewName("redirect:/instituicoes/listar");
        return modelAndView;
    }

    @ModelAttribute("ufs")
    public UF[] listUFS() {
        return UF.values();
    }
}
