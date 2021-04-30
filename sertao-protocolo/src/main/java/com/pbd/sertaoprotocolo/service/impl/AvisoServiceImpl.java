package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.repository.AvisoRepository;
import com.pbd.sertaoprotocolo.service.AvisoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AvisoServiceImpl implements AvisoService {

    @Autowired
    AvisoRepository avisoRepository;

    @Override
    public List<Aviso> getAvisos() {
        return avisoRepository.findAll();
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
    public Aviso updateAviso(Long id, Aviso aviso) {
        Aviso c = avisoRepository.findById(id).get();

        return c;
    }

    @Override
    public Aviso deleteAviso(Long id) {
        return null;
    }

}
