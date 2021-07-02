package com.pbd.sertaoprotocolo;

import com.pbd.sertaoprotocolo.model.Cidade;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Role;
import com.pbd.sertaoprotocolo.model.User;
import com.pbd.sertaoprotocolo.repository.RoleRepository;
import com.pbd.sertaoprotocolo.service.CidadeService;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import com.pbd.sertaoprotocolo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DummyData {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    CidadeService cidadeService;

    @Autowired
    RoleRepository roleRepository;

//    @PostConstruct
    public void saveUser() {

        Cidade cidade = new Cidade();
        cidade.setNome("Serra Talhada");

        cidadeService.createCidade(cidade);

        Role role = new Role();
        role.setRole("ADMIN");
        roleRepository.save(role);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Ananias Raphel");
        funcionario.setMatricula("0000");

        Funcionario funcionario1 = funcionarioService.createFuncionario(funcionario);


        User user = new User();
        user.setFuncionario(funcionario);
        user.setUserName("ananias");
        user.setActive(true);
        user.setPassword("ananias123");
        user.setEmail("admin@admin.com");

        userService.saveUser(user);

//        Role role = new Role();
//        role.setRole("USER");
//        roleRepository.save(role);

    }

}
