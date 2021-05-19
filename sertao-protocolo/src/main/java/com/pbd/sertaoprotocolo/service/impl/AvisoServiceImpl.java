package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.repository.AvisoRepository;
import com.pbd.sertaoprotocolo.service.AvisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvisoServiceImpl implements AvisoService {

    @Autowired
    AvisoRepository avisoRepository;

    @Override
    public List<Aviso> getAvisos() {
        return avisoRepository.findAll();
    }

    @Override
    @Transactional
    public List<Aviso> getAvisosFuncionarios(Funcionario funcionario) {
        return avisoRepository.findAllByFuncionarios(funcionario);
    }

    @Override
    public Aviso getAviso(Long id) {
        return avisoRepository.findById(id).get();
    }

    @Override
    public Aviso createAviso(Aviso aviso) {
        return avisoRepository.save(aviso);
    }

    @Override
    public Aviso updateAviso(Aviso aviso) {
        return avisoRepository.save(aviso);
    }

    @Override
    public Aviso deleteAviso(Long id) {
        return null;
    }

}
