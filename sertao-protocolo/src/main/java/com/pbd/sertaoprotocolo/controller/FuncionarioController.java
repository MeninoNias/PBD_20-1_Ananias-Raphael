package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.*;
import com.pbd.sertaoprotocolo.service.CargoService;
import com.pbd.sertaoprotocolo.service.CidadeService;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import com.pbd.sertaoprotocolo.service.SubSetorService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private SubSetorService subSetorService;

    @GetMapping("/listar")
    public ModelAndView listFuncionario() {
        ModelAndView view = new ModelAndView();
        view.addObject("funcionarios", funcionarioService.getFuncionarios());
        view.setViewName("funcionario/listar_funcionario");
        return view;
    }

    @GetMapping("/new_func")
    public ModelAndView createFuncionario(Funcionario funcionario) {
        ModelAndView view = new ModelAndView();
        view.addObject("cargos", cargoService.getCargos());
        view.addObject("cidades", cidadeService.getCidades());
        view.addObject("lotacoes", subSetorService.getSubSetors());
        view.setViewName("funcionario/form_funcionario");
        return view;
    }

    @RequestMapping(value = "/new_func", method = RequestMethod.POST)
    public ModelAndView registerFuncionario(@Valid Funcionario funcionario, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        Funcionario funcionarioExist = funcionarioService.getFuncionarioMat(funcionario.getMatricula());
        if (funcionarioExist != null) {
            result.rejectValue("matricula", "error.funcionario", "Já existe um funcionario registrado com o essa matricula.");
            if (result.hasErrors()) {
                modelAndView.setViewName("funcionario/form_funcionario");
            }
        } else {
            funcionarioService.createFuncionario(funcionario);
            modelAndView.addObject("successMessage", "Funcionario registrado com sucesso");
            modelAndView.setViewName("redirect:/funcionarios/listar");
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateFuncionario(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Funcionario funcionario = funcionarioService.getFuncionario(id);
        view.addObject("funcionario", funcionario);
        view.addObject("cargos", cargoService.getCargos());
        view.addObject("cidades", cidadeService.getCidades());
        view.addObject("lotacoes", subSetorService.getSubSetors());
        view.setViewName("funcionario/form_funcionario");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateFuncionario(@Valid Funcionario funcionario, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("funcionario/form_funcionario");
        }
        funcionarioService.createFuncionario(funcionario);
        modelAndView.addObject("successMessage", "Funcionario registrado com sucesso");
        modelAndView.setViewName("redirect:/funcionarios/listar");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailFuncionario(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Funcionario funcionario = funcionarioService.getFuncionario(id);
        view.addObject("funcionario", funcionario);
        view.setViewName("funcionario/detail_funcionario");
        return view;
    }

    @ModelAttribute("ufs")
    public UF[] listUFS() {
        return UF.values();
    }

}
