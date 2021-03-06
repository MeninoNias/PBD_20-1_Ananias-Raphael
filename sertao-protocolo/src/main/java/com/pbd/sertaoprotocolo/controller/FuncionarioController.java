package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.*;
import com.pbd.sertaoprotocolo.service.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private SubSetorService subSetorService;

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @GetMapping("/listar")
    public ModelAndView listFuncionario() {
        ModelAndView view = new ModelAndView();
        view.addObject("funcionarios", funcionarioService.getFuncionarios());
        view.setViewName("funcionario/listar_funcionario");
        return view;
    }

    @GetMapping("/new_func")
    public ModelAndView createFuncionario(Funcionario funcionario) {
        ModelAndView view = new ModelAndView();
        view.addObject("cargos", cargoService.getCargos());
        view.addObject("cidades", cidadeService.getCidades());
        view.addObject("lotacoes", subSetorService.getSubSetors());
        view.setViewName("funcionario/form_funcionario");
        return view;
    }

    @RequestMapping(value = "/new_func", method = RequestMethod.POST)
    public ModelAndView registerFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();

        Funcionario funcionarioExist = funcionarioService.getFuncionarioMat(funcionario.getMatricula());
        if (funcionarioExist != null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, funcionario.getNome()+" - J?? existe um funcionario registrado com o essa matricula", Operacoes.IN));
            result.rejectValue("matricula", "error", "J?? existe um funcionario registrado com o essa matricula.");
            if (result.hasErrors()) {
                modelAndView.setViewName("funcionario/form_funcionario");
            }
        } else {
            funcionarioService.createFuncionario(funcionario);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByUserName(auth.getName());
            logService.createLog(new Log(user, funcionario.getNome()+" - Funcionario registrado com sucesso", Operacoes.IN));
            attributes.addFlashAttribute("success", "Funcionario registrado com sucesso");
            modelAndView.setViewName("redirect:/funcionarios/listar");
        }
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateFuncionario(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Funcionario funcionario = funcionarioService.getFuncionario(id);
        view.addObject("funcionario", funcionario);
        view.addObject("cargos", cargoService.getCargos());
        view.addObject("cidades", cidadeService.getCidades());
        view.addObject("lotacoes", subSetorService.getSubSetors());
        view.setViewName("funcionario/form_funcionario");
        return view;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {
            modelAndView.setViewName("funcionario/form_funcionario");
        }

        funcionarioService.createFuncionario(funcionario);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        logService.createLog(new Log(user, funcionario.getNome()+" - Funcionario atualizado com sucesso", Operacoes.UP));
        attributes.addFlashAttribute("success", "Funcionario alterado com sucesso");
        modelAndView.setViewName("redirect:/funcionarios/listar");
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detailFuncionario(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView();
        Funcionario funcionario = funcionarioService.getFuncionario(id);
        view.addObject("funcionario", funcionario);
        view.setViewName("funcionario/detail_funcionario");
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteFuncionario(@PathVariable("id") Long id, RedirectAttributes attributes) {
        ModelAndView view = new ModelAndView();
        Funcionario funcionario = funcionarioService.getFuncionario(id);
        funcionarioService.deleteFuncionario(funcionario.getId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        logService.createLog(new Log(user, funcionario.getNome()+" - Funcionario deletado com sucesso", Operacoes.DE));
        attributes.addFlashAttribute("success", "Funcionario deletado com sucesso");
        view.setViewName("redirect:/funcionarios/listar");
        return view;
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=funcioanrios_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        ServletOutputStream outputStream = response.getOutputStream();
        XSSFWorkbook sheets = funcionarioService.exportExel();
        sheets.write(outputStream);
        sheets.close();
        outputStream.close();
    }

    @ModelAttribute("ufs")
    public UF[] listUFS() {
        return UF.values();
    }

}
