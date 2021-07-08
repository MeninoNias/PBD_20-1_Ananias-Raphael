package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.service.AvisoService;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
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

    @Autowired
    private ProtocoloService protocoloService;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/home")
    public ModelAndView home(HttpSession session){
        ModelAndView view = new ModelAndView();
        Object[] list = protocoloService.getContProtocolos().toArray();
        view.addObject("protocolosResp", list.length > 0 ? list[0] : 0);
        view.addObject("protocolosPend", list.length > 1 ? list[1] : 0);
        view.addObject("protocolosCanc", list.length > 2 ? list[1] : 0);
        view.addObject("funcs", funcionarioService.countFunc());


        view.setViewName("home");
        return view;
    }

    @GetMapping("/home_user")
    public ModelAndView homeUser(HttpSession session){
        ModelAndView view = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());

        List<Aviso> avisos = avisoService.getAvisosFuncionarios(user.getFuncionario());

        view.addObject("avisos", avisos);
        view.setViewName("home_user");

        return view;
    }

}
