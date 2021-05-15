package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.dto.UserMatDTO;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Role;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.UserService;
import com.pbd.sertaoprotocolo.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.Set;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login/login");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        UserMatDTO userMatDTO = new UserMatDTO();
        modelAndView.addObject("userMatDTO", userMatDTO);
        modelAndView.setViewName("login/create_user");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid UserMatDTO userMatDTO, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();

        Funcionario funcionarioExist = funcionarioService.getFuncionarioMat(userMatDTO.getMatricula());
        if (funcionarioExist != null) {
            User userExists = userService.findUserByUserName(userMatDTO.getUserName());
            if (userExists != null) {
                result.rejectValue("userName", "error.userMatDTO", "Já existe um usuário registrado com o nome de usuário fornecido");
            }
            if (result.hasErrors()) {
                modelAndView.setViewName("login/create_user");
            } else {
                User user1 = userMatDTO.transformaParaObjeto();
                user1.setFuncionario(funcionarioExist);
                userService.saveUser(user1);
                modelAndView.addObject("successMessage", "Usuario registrado com sucesso");
                modelAndView.setViewName("redirect:/login");
            }
        } else {
            result.rejectValue("matricula", "error.userMatDTO", "Funcinario não cadastrado");
            if (result.hasErrors()) {
                modelAndView.addObject("userMatDTO", userMatDTO);
                modelAndView.setViewName("login/create_user");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/after_login")
    public String afterLogin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        Set<Role> roleSet = user.getRoles();
        for (Role role : roleSet) {
            if (role.getRole().equals("ADMIN")) {
                return "redirect:/home";
            } else if (role.getRole().equals("USER_ADMIN")) {
                return "redirect:/home";
            }
        }
        return "redirect:/home_user";
    }
}
