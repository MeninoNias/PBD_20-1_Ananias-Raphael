package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Cargo;
import com.pbd.sertaoprotocolo.model.Log;
import com.pbd.sertaoprotocolo.model.Operacoes;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.CargoService;
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

@RequestMapping("/cargos")
@Controller
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private UserService userService;
    @Autowired
    private LogService logService;

    @GetMapping("/listar")
    public ModelAndView listCargo() {
        ModelAndView view = new ModelAndView();
        view.addObject("cargos", cargoService.getCargos());
        view.setViewName("cargo/cargo_list");
        return view;
    }

    @GetMapping("/new_cargo")
    public ModelAndView createCargo(Cargo cargo) {
        ModelAndView view = new ModelAndView();
        view.setViewName("cargo/cargo_form");
        return view;
    }

    @RequestMapping(value = "/new_cargo", method = RequestMethod.POST)
    public ModelAndView registerCargo(@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        cargo.setNome(cargo.getNome().toUpperCase());
        Cargo cargoExist = cargoService.getCargoNome(cargo.getNome());
        if (cargoExist != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, cargo.getNome() + " - Cargo não foi criado (Já existe um cargo registrado com o essa nome)", Operacoes.IN));
            result.rejectValue("nome", "error.cargo", "Já existe um cargo registrado com o essa nome.");
            attributes.addFlashAttribute("error", "Já existe um cargo registrado com o essa nome.");
            if (result.hasErrors()) {
                modelAndView.setViewName("cargo/cargo_form");
            }
        } else {
            cargoService.createCargo(cargo);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, cargo.getNome() + " - Cargo criado com sucesso", Operacoes.IN));
            attributes.addFlashAttribute("success", "Cargo registrado com sucesso");
            modelAndView.setViewName("redirect:/cargos/listar");
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createCargo(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Cargo cargo = cargoService.getCargo(id);
        view.addObject("cargo", cargo);
        view.setViewName("cargo/cargo_form");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateCargo(@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        cargo.setNome(cargo.getNome().toUpperCase());
        Cargo cargoExist = cargoService.getCargoNome(cargo.getNome());
        if (cargoExist != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, cargo.getNome() + " - Cargo não foi atualizado (Já existe um cargo registrado com o essa nome)", Operacoes.IN));
            result.rejectValue("nome", "error.cargo", "Já existe um cargo registrado com o essa nome.");
            if (result.hasErrors()) {
                modelAndView.setViewName("cargo/cargo_form");
            }
        } else {
            cargoService.createCargo(cargo);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, cargo.getNome() + " - Cargo atualizado com sucesso", Operacoes.UP));
            attributes.addFlashAttribute("successMessage", "Cargo registrado com sucesso");
            modelAndView.setViewName("redirect:/cargos/listar");
        }
        return modelAndView;
    }
}
