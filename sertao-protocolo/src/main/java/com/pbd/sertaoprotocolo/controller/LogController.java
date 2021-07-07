package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Log;
import com.pbd.sertaoprotocolo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/listar")
    public ModelAndView listLog() {
        ModelAndView view = new ModelAndView();
        view.addObject("logs", logService.getLogs());
        view.setViewName("log/log_list");
        return view;
    }

    @GetMapping("/new_log")
    public ModelAndView createLog(Log log) {
        ModelAndView view = new ModelAndView();
        view.setViewName("log/log_form");
        return view;
    }

    @RequestMapping(value = "/new_log", method = RequestMethod.POST)
    public ModelAndView registerLog(@Valid Log log, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("log/log_form");
        }
        logService.createLog(log);
        attributes.addFlashAttribute("success", "Log registrado com sucesso");
        modelAndView.setViewName("redirect:/logs/listar");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createLog(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Log log = logService.getLog(id);
        view.addObject("log", log);
        view.setViewName("log/log_form");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateLog(@Valid Log log, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();
        if (result.hasErrors()) {
            modelAndView.setViewName("log/log_form");
        }
        logService.createLog(log);
        attributes.addFlashAttribute("successMessage", "Log registrado com sucesso");
        modelAndView.setViewName("redirect:/logs/listar");
        return modelAndView;
    }
}
