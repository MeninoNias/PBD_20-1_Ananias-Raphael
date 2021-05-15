package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.CategoriaProtocolo;
import com.pbd.sertaoprotocolo.service.CategoriaProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/categorias")
@Controller
public class CategoriaController {

    @Autowired
    private CategoriaProtocoloService categoriaService;

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
    public ModelAndView registerCategoria(@Valid CategoriaProtocolo categoriaProtocolo, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        categoriaProtocolo.setNome(categoriaProtocolo.getNome().toUpperCase());
        CategoriaProtocolo categoriaExist = categoriaService.getCategoriaProtocoloNome(categoriaProtocolo.getNome());
        if (categoriaExist != null) {
            result.rejectValue("nome", "error.categoria", "Já existe um categoria registrado com o essa nome.");
            if (result.hasErrors()) {
                modelAndView.setViewName("categoria_protocolo/categoria_form");
            }
        } else {
            categoriaService.createCategoriaProtocolo(categoriaProtocolo);
            modelAndView.addObject("successMessage", "Categoria registrado com sucesso");
            modelAndView.setViewName("redirect:/categorias/listar");
        }
        return modelAndView;
    }
}
