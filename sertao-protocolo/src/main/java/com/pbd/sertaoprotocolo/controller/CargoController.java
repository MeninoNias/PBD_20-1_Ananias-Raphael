package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Cargo;
import com.pbd.sertaoprotocolo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/cargos")
@Controller
public class CargoController {

    @Autowired
    private CargoService cargoService;

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
    public ModelAndView registerCargo(@Valid Cargo cargo, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        cargo.setNome(cargo.getNome().toUpperCase());
        Cargo cargoExist = cargoService.getCargoNome(cargo.getNome());
        if (cargoExist != null) {
            System.out.println("aqui");
            result.rejectValue("nome", "error.cargo", "Já existe um cargo registrado com o essa nome.");
            if (result.hasErrors()) {
                modelAndView.setViewName("cargo/cargo_form");
            }
        } else {
            cargoService.createCargo(cargo);
            modelAndView.addObject("successMessage", "Cargo registrado com sucesso");
            modelAndView.setViewName("redirect:/cargos/listar");
        }
        return modelAndView;
    }
}
