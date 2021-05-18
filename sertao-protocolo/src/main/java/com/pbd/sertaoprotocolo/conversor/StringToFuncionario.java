package com.pbd.sertaoprotocolo.conversor;

import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToFuncionario implements Converter<String, Funcionario> {

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    public Funcionario convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return funcionarioService.getFuncionario(id);
    }
}
