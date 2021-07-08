package com.pbd.sertaoprotocolo.controller;


import com.pbd.sertaoprotocolo.model.*;
import com.pbd.sertaoprotocolo.service.CategoriaProtocoloService;
import com.pbd.sertaoprotocolo.service.LogService;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
import com.pbd.sertaoprotocolo.service.UserService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/protocolos")
public class ProtocoloController {

    @Autowired
    public ProtocoloService protocoloService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;


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

        logService.createLog(new Log(user, protocolo.getAssunto() + " - Protocolo registrado com sucesso", Operacoes.IN));

        modelAndView.addObject("successMessage", "Protocolo registrado com sucesso");
        modelAndView.setViewName("redirect:/protocolos/my_protocol");

        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView createProtocolo(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Protocolo protocolo = protocoloService.getProtocolo(id);
        view.addObject("categorias", categoriaProtocoloService.getCategoriaProtocolos());
        view.addObject("protocolo", protocolo);
        view.setViewName("protocolo/form_protocolo");
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProtocolo(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Protocolo protocolo = protocoloService.getProtocolo(id);
        protocoloService.deleteProtocolo(protocolo.getId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        logService.createLog(new Log(user, protocolo.getAssunto() + " - Protocolo deletado com sucesso", Operacoes.DE));
        view.setViewName("redirect:/protocolos/my_protocol");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateProtocolo(@Valid Protocolo protocolo, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        protocolo.setAssunto(protocolo.getAssunto().toUpperCase());
        if (result.hasErrors()) {
            modelAndView.setViewName("protocolo/protocolo_form");
        } else {
            protocoloService.updateProtocolo(protocolo);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, protocolo.getAssunto() + " - Protocolo atualizado com sucesso", Operacoes.UP));
            modelAndView.addObject("successMessage", "Protocolo registrado com sucesso");
            modelAndView.setViewName("redirect:/protocolos/my_protocol");
        }
        return modelAndView;
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=protocolos_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        ServletOutputStream outputStream = response.getOutputStream();
        XSSFWorkbook sheets = protocoloService.exportExel();
        sheets.write(outputStream);
        sheets.close();
        outputStream.close();
    }

}
