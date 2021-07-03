package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Instituicao;
import com.pbd.sertaoprotocolo.repository.InstituicaoRepository;
import com.pbd.sertaoprotocolo.service.InstituicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituicaoServiceimpl implements InstituicaoService {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    @Override
    public List<Instituicao> getInstituicaos() {
        return instituicaoRepository.findByAtivoBanco(true);
    }

    @Override
    public Instituicao getInstituicaoCNPJ(String cnpj) {
        return null;
    }

    @Override
    public Instituicao getInstituicao(Long id) {
        return instituicaoRepository.findById(id).get();
    }

    @Override
    public Instituicao createInstituicao(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    @Override
    public Instituicao updateInstituicao(Instituicao instituicao) {
        return instituicaoRepository.save(instituicao);
    }

    @Override
    public Instituicao deleteInstituicao(Long id) {
        Instituicao instituicao = getInstituicao(id);
        instituicao.setAtivoBanco(false);
        updateInstituicao(instituicao);
        return instituicao;
    }


}
