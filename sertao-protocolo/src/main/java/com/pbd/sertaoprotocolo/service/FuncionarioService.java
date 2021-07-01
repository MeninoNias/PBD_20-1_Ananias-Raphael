package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Funcionario;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public interface FuncionarioService {

    List<Funcionario> getFuncionarios();

    Funcionario getFuncionario(Long id);

    Funcionario getFuncionarioMat(String mat);

    Funcionario createFuncionario(Funcionario funcionario);

    Funcionario updateFuncionario(Funcionario funcionario);

    Funcionario deleteFuncionario(Long id);

    XSSFWorkbook exportExel();

}
