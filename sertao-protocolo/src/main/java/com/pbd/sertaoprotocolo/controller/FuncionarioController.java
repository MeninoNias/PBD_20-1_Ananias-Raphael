package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Cargo;
import com.pbd.sertaoprotocolo.model.Cidade;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.UF;
import com.pbd.sertaoprotocolo.service.CargoService;
import com.pbd.sertaoprotocolo.service.CidadeService;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @GetMapping("/listar")
    public String listFuncionario() {
        return "funcionario/listar_funcionario";
    }

    @GetMapping("/new_func")
    public ModelAndView createFuncionario(Funcionario funcionario) {
        ModelAndView view = new ModelAndView();
        view.addObject("cargos", cargoService.getCargos());
        view.addObject("cidades", cidadeService.getCidades());
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

    @ModelAttribute("ufs")
    public UF[] listUFS(){
        return UF.values();
    }

}
