package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.RespostaProtocolo;
import com.pbd.sertaoprotocolo.model.StatusProtocolo;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.RespostaProtocoloService;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
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
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/resposta_protocolo")
public class RespostaProtocoloController {

    @Autowired
    private ProtocoloService protocoloService;

    @Autowired
    private UserService userService;

    @Autowired
    private RespostaProtocoloService resposta_protocoloService;

    @GetMapping("/listar")
    public ModelAndView listarRespostaProtocolos(RespostaProtocolo respostaProtocolo) {
        ModelAndView view = new ModelAndView();
        view.addObject("resposta_protocolos", resposta_protocoloService.getRespostaProtocolos());
        view.setViewName("resposta_protocolo/listar_resposta_protocolo");
        return view;
    }


    @GetMapping("/new_resposta_protocolo/{id_protocolo}")
    public ModelAndView createRespostaProtocolo(RespostaProtocolo respostaProtocolo, @PathVariable("id_protocolo") Long id) {
        ModelAndView view = new ModelAndView();
        Protocolo protocolo = protocoloService.getProtocolo(id);
        if (protocolo.getStatus() != StatusProtocolo.RE
                || protocolo.getStatus() != StatusProtocolo.CA
                || protocolo.getStatus() != StatusProtocolo.AN) {
            protocolo.setStatus(StatusProtocolo.AN);
            protocoloService.updateProtocolo(protocolo);
        }
        view.addObject("protocolo", protocolo);
        view.setViewName("resposta_protocolo/form_resposta_protocolo");
        return view;
    }

    @RequestMapping(value = "/new_resposta_protocolo/{id_protocolo}", method = RequestMethod.POST)
    public ModelAndView registerRespostaProtocolo(@Valid RespostaProtocolo resposta_protocolo, @PathVariable("id_protocolo") Long id, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        Protocolo protocolo = protocoloService.getProtocolo(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        protocolo.setStatus(StatusProtocolo.RE);
        resposta_protocolo.setResposta(resposta_protocolo.getResposta().toUpperCase());
        resposta_protocolo.setDataResposta(LocalDate.now());
        resposta_protocolo.setProtocolo(protocolo);
        resposta_protocolo.setFuncionarioResponsavel(user.getFuncionario());

        if (result.hasErrors()) {
            modelAndView.setViewName("resposta_protocolo/form_resposta_protocolo");
        }
        resposta_protocoloService.createRespostaProtocolo(resposta_protocolo);
        modelAndView.addObject("successMessage", "RespostaProtocolo registrado com sucesso");
        modelAndView.setViewName("redirect:/protocolos/listar");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createRespostaProtocolo(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        RespostaProtocolo resposta_protocolo = resposta_protocoloService.getRespostaProtocolo(id);
        view.addObject("resposta_protocolo", resposta_protocolo);
        view.setViewName("resposta_protocolo/form_resposta_protocolo");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateRespostaProtocolo(@Valid RespostaProtocolo respostaProtocolo, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        respostaProtocolo.setResposta(respostaProtocolo.getResposta().toUpperCase());
        respostaProtocolo.setDataResposta(LocalDate.now());
        respostaProtocolo.setFuncionarioResponsavel(user.getFuncionario());

        if (result.hasErrors()) {
            modelAndView.setViewName("resposta_protocolo/form_resposta_protocolo");
        }
        resposta_protocoloService.createRespostaProtocolo(respostaProtocolo);
        modelAndView.addObject("successMessage", "RespostaProtocolo registrado com sucesso");
        modelAndView.setViewName("redirect:/protocolos/listar");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailRespostaProtocolo(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Protocolo protocolo = protocoloService.getProtocolo(id);
        view.addObject("protocolo", protocolo);
        view.setViewName("resposta_protocolo/detail_resposta_protocolo");
        return view;
    }
}
