package com.pbd.sertaoprotocolo.controller;

import com.pbd.sertaoprotocolo.backup.Backup;
import com.pbd.sertaoprotocolo.export.UserExport;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.repository.RoleRepository;
import com.pbd.sertaoprotocolo.service.UserService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    private Backup backup;

    @GetMapping("/listar")
    public ModelAndView listUser() {
        ModelAndView view = new ModelAndView();
        view.addObject("users", userService.getUsers());
        view.setViewName("user/listar_user");
        return view;
    }

    @GetMapping("/update/{id}")
    public ModelAndView listUser(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("user/user_update");
        User user = userService.findById(id);
        mv.addObject("user", user);
        mv.addObject("use_roles", roleRepository.findAll());
        return mv;
    }

    @GetMapping("/reset_user_password/{id}")
    public String resetPassword(@PathVariable("id") long id, RedirectAttributes attr) {
        User user = userService.findById(id);

        String s = user.getFuncionario().getNome();
        String[] s1 = s.split(" ");
        user.setPassword(s1[0].toLowerCase() + "" + user.getFuncionario().getMatricula());

        if (userService.updateUser(user) != null) {
            attr.addFlashAttribute("success", "Senha do " + user.getUserName() + " resatada com sucesso.");
        }

        return "redirect:/users/listar";
    }

    @GetMapping("/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        ServletOutputStream outputStream = response.getOutputStream();
        XSSFWorkbook sheets = userService.exportExel();
        sheets.write(outputStream);
        sheets.close();
        outputStream.close();
    }

}
