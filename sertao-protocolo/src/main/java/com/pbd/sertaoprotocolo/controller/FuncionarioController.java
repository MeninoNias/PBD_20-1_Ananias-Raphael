package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.dto.UserMatDTO;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public String listFuncionario() {
        return "funcionario/listar_funcionario";
    }

    @GetMapping("/new_func")
    public String createFuncionario() {
        return "funcionario/form_funcionario";
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
            funcionarioService.createFuncionario(funcionarioExist);
            modelAndView.addObject("successMessage", "Funcionario registrado com sucesso");
            modelAndView.addObject("funcionario", new Funcionario());
            modelAndView.setViewName("funcionario/listar");
        }
        return modelAndView;
    }

}
