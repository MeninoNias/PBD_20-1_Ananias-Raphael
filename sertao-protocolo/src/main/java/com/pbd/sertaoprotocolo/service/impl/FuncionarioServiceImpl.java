package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.export.FuncionarioExport;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.repository.FuncionarioRepository;
import com.pbd.sertaoprotocolo.service.FuncionarioService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    private FuncionarioExport funcExport;


    @Override
    @Transactional
    public List<Funcionario> getFuncionarios() {
        return funcionarioRepository.findFuncionariosByAtivoBanco(true);
    }

    @Override
    public Funcionario getFuncionario(Long id) {
        return funcionarioRepository.findById(id).get();
    }

    @Override
    public Funcionario getFuncionarioMat(String mat) {
        return funcionarioRepository.findByMatricula(mat);
    }

    @Override
    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario updateFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Funcionario deleteFuncionario(Long id) {
        Funcionario funcionario = getFuncionario(id);
        funcionario.setAtivoBanco(false);
        updateFuncionario(funcionario);
        return funcionario;
    }

    @Override
    public XSSFWorkbook exportExel() {
        funcExport = new FuncionarioExport();
        funcExport.exelCabelcalho();
        funcExport.popularLinhas(getFuncionarios());

        return funcExport.getWorkbook();

    }

}
