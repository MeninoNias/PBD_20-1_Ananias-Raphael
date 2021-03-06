package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.CategoriaProtocolo;
import com.pbd.sertaoprotocolo.model.Log;
import com.pbd.sertaoprotocolo.model.Operacoes;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.CategoriaProtocoloService;
import com.pbd.sertaoprotocolo.service.LogService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@RequestMapping("/categorias")
@Controller
public class CategoriaController {

    @Autowired
    private CategoriaProtocoloService categoriaService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @GetMapping("/listar")
    public ModelAndView listCategoria() {
        ModelAndView view = new ModelAndView();
        view.addObject("categorias", categoriaService.getCategoriaProtocolos());
        view.setViewName("categoria_protocolo/categoria_list");
        return view;
    }

    @GetMapping("/new_categoria")
    public ModelAndView createCategoria(CategoriaProtocolo categoriaProtocolo) {
        ModelAndView view = new ModelAndView();
        view.setViewName("categoria_protocolo/categoria_form");
        return view;
    }

    @RequestMapping(value = "/new_categoria", method = RequestMethod.POST)
    public ModelAndView registerCategoria(@Valid CategoriaProtocolo categoriaProtocolo, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        categoriaProtocolo.setNome(categoriaProtocolo.getNome().toUpperCase());
        CategoriaProtocolo categoriaExist = categoriaService.getCategoriaProtocoloNome(categoriaProtocolo.getNome());
        if (categoriaExist != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, categoriaProtocolo.getNome() + " - Categoria n??o foi criada (J?? existe um categoria registrado com o essa nome.)", Operacoes.IN));
            result.rejectValue("nome", "error.categoria", "J?? existe um categoria registrado com o essa nome.");
            if (result.hasErrors()) {
                modelAndView.setViewName("categoria_protocolo/categoria_form");
            }
        } else {
            categoriaService.createCategoriaProtocolo(categoriaProtocolo);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, categoriaProtocolo.getNome() + " - Categoria criada com sucesso", Operacoes.IN));
            attributes.addFlashAttribute("success", "Categoria registrado com sucesso");
            modelAndView.setViewName("redirect:/categorias/listar");
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createCategoriaProtocolo(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        CategoriaProtocolo categoriaProtocolo = categoriaService.getCategoriaProtocolo(id);
        view.addObject("categoriaProtocolo", categoriaProtocolo);
        view.setViewName("categoria_protocolo/categoria_form");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateCategoriaProtocolo(@Valid CategoriaProtocolo categoriaProtocolo, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        categoriaProtocolo.setNome(categoriaProtocolo.getNome().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("categoria_protocolo/categoria_form");
        }
        categoriaService.createCategoriaProtocolo(categoriaProtocolo);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        logService.createLog(new Log(user, categoriaProtocolo.getNome() + " - Categoria atualizada com sucesso", Operacoes.UP));
        attributes.addFlashAttribute("success", "CategoriaProtocolo registrado com sucesso");
        modelAndView.setViewName("redirect:/categorias/listar");
        return modelAndView;
    }
}
