package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> getFuncionarios();
    Funcionario getFuncionario(Long id);
    Funcionario createFuncionario(Funcionario funcionario);
    Funcionario updateFuncionario(Long id, Funcionario funcionario);
    Funcionario deleteFuncionario(Long id);
}
