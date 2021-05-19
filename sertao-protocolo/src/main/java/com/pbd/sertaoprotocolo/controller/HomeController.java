package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.AvisoService;
import com.pbd.sertaoprotocolo.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AvisoService avisoService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession session){
        ModelAndView view = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        session.setAttribute("user", user);
        view.setViewName("home");

        return view;
    }

    @GetMapping("/home_user")
    public ModelAndView homeUser(HttpSession session){
        ModelAndView view = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        List<Aviso> avisos = avisoService.getAvisosFuncionarios(user.getFuncionario());
        session.setAttribute("user", user);
        view.addObject("avisos", avisos);
        view.setViewName("home_user");

        return view;
    }

}
