package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Setor;
import com.pbd.sertaoprotocolo.repository.SetorRepository;
import com.pbd.sertaoprotocolo.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SetorServiceImpl implements SetorService {

    @Autowired
    SetorRepository setorRepository;

    @Override
    public List<Setor> getSetors() {
        return setorRepository.findAll();
    }

    @Override
    public Setor getSetor(Long id) {
        return setorRepository.findById(id).get();
    }

    @Override
    public Setor createSetor(Setor setor) {
        return setorRepository.save(setor);
    }

    @Override
    public Setor updateSetor(Long id, Setor setor) {
        Setor c = setorRepository.findById(id).get();
        //UpdadeSetor
        return c;
    }

    @Override
    public Setor deleteSetor(Long id) {
        return null;
    }


}
