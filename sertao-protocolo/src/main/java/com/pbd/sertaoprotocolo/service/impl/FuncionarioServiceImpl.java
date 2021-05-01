package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.repository.FuncionarioRepository;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario getFuncionario(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario updateFuncionario(Long id, Funcionario funcionario) {
        Funcionario c = funcionarioRepository.findById(id).get();

        return c;
    }

    @Override
    public Funcionario deleteFuncionario(Long id) {
        return null;
    }

}
