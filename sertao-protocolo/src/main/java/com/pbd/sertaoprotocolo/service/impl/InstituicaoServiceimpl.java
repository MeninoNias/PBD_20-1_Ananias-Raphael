package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Instituicao;
import com.pbd.sertaoprotocolo.repository.InstituicaoRepository;
import com.pbd.sertaoprotocolo.service.InstituicaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InstituicaoServiceimpl implements InstituicaService {

    @Autowired
    InstituicaoRepository instituicaoRepository;

    @Override
    public List<Instituicao> getInstituicaos() {
        return instituicaoRepository.findAll();
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
    public Instituicao updateInstituicao(Long id, Instituicao instituicao) {
        Instituicao c = instituicaoRepository.findById(id).get();
        //UpdadeInstituicao
        return c;
    }

    @Override
    public Instituicao deleteInstituicao(Long id) {
        return null;
    }


}
