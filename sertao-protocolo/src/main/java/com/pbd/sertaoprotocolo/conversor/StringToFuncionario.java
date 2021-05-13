package com.pbd.sertaoprotocolo.conversor;

import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.service.impl.FuncionarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFuncionario implements Converter<String, Funcionario> {

    @Autowired
    private FuncionarioServiceImpl funcionarioService;

    @Override
    public Funcionario convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Funcionario funcionario = funcionarioService.getFuncionarioMat(s);
        return funcionario;
    }
}
