package com.pbd.sertaoprotocolo.controller;


import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.CategoriaProtocoloService;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
import com.pbd.sertaoprotocolo.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/protocolos")
public class ProtocoloController {

    @Autowired
    public ProtocoloService protocoloService;

    @Autowired
    public UserService userService;

    @Autowired
    public CategoriaProtocoloService categoriaProtocoloService;

    @GetMapping("/listar")
    public ModelAndView listarProtocolos() {
        ModelAndView view = new ModelAndView();

        List<Protocolo> protocolos = protocoloService.getProtocolos();
        view.addObject("protocolos", protocolos);

        view.setViewName("protocolo/listar_protocolo");
        return view;
    }

    @GetMapping("/my_protocol")
    public ModelAndView listarMeusProtocolos() {
        ModelAndView view = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        if (user.getFuncionario() != null) {
            Funcionario funcionario = user.getFuncionario();
            List<Protocolo> protocolos = protocoloService.getProtocolosByFuncionarios(funcionario);
            view.addObject("protocolos", protocolos);
        } else {
            view.addObject("errorMessage", "Funcionario não indentificado");
            view.setViewName("redirect:/home_user");
            return view;
        }

        view.setViewName("protocolo/listar_protocolo");
        return view;
    }

    @GetMapping("/new_protocolo")
    public ModelAndView createProtocolo(Protocolo protocolo) {
        ModelAndView view = new ModelAndView();
        view.addObject("categorias", categoriaProtocoloService.getCategoriaProtocolos());
        view.setViewName("protocolo/form_protocolo");
        return view;
    }

    @RequestMapping(value = "/new_protocolo", method = RequestMethod.POST)
    public ModelAndView registerProtocolo(@Valid Protocolo protocolo, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("protocolo/form_protocolo");
        }

        protocolo.setAssunto(protocolo.getAssunto().toUpperCase());
        protocolo.setDescricao(protocolo.getDescricao().toUpperCase());
        protocolo.setDataInicio(LocalDate.now());
        String nProtocolo =
                protocoloService.contAll() + "" +
                        protocolo.getCategoria().getAbreviacao() + "" +
                        LocalDate.now().getYear();
        protocolo.setNProtocolo(nProtocolo);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        if (user.getFuncionario() != null) {
            protocolo.setFuncionario(user.getFuncionario());
        }

        protocoloService.createProtocolo(protocolo);

        modelAndView.addObject("successMessage", "Protocolo registrado com sucesso");
        modelAndView.setViewName("redirect:/protocolos/my_protocol");

        return modelAndView;
    }

}
