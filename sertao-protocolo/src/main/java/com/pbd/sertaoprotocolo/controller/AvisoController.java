package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.AvisoService;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import com.pbd.sertaoprotocolo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/avisos")
public class AvisoController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private UserService userService;

    @Autowired
    private AvisoService avisoService;

    @GetMapping("/listar")
    public ModelAndView listarAvisos(Aviso aviso) {
        ModelAndView view = new ModelAndView();
        view.addObject("avisos", avisoService.getAvisos());
        view.setViewName("aviso/listar_aviso");
        return view;
    }

    @GetMapping("/my_avisos")
    public ModelAndView listarMeusAvisos(Aviso aviso) {
        ModelAndView view = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        List<Aviso> avisos = avisoService.getAvisosFuncionarios(user.getFuncionario());

        view.addObject("avisos", avisos);
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

    @RequestMapping(value = "/new_aviso", method = RequestMethod.POST)
    public ModelAndView registerAviso(@Valid Aviso aviso, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        aviso.setTitulo(aviso.getTitulo().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("aviso/form_aviso");
        }
        avisoService.createAviso(aviso);
        modelAndView.addObject("successMessage", "Aviso registrado com sucesso");
        modelAndView.setViewName("redirect:/avisos/listar");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createAviso(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Aviso aviso = avisoService.getAviso(id);
        view.addObject("funcionariosSelect", funcionarioService.getFuncionarios());
        view.addObject("aviso", aviso);
        view.setViewName("aviso/update_aviso");
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteAviso(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Aviso aviso = avisoService.getAviso(id);
        if (aviso.getFuncionarios().size() != 0) {
            view.addObject("errorMensage", "Aviso não pode ser deletado");
        } else {
            avisoService.deleteAviso(aviso.getId());
        }
        view.setViewName("redirect:/avisos/listar");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateAviso(@Valid Aviso aviso, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        aviso.setTitulo(aviso.getTitulo().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("aviso/form_aviso");
        }
        avisoService.createAviso(aviso);
        modelAndView.addObject("successMessage", "Aviso registrado com sucesso");
        modelAndView.setViewName("redirect:/avisos/listar");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailAviso(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Aviso aviso = avisoService.getAviso(id);
        view.addObject("aviso", aviso);
        view.setViewName("aviso/detail_aviso");
        return view;
    }

}
