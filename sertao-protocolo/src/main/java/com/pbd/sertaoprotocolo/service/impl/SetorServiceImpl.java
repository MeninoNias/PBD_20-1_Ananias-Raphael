package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.Setor;
import com.pbd.sertaoprotocolo.repository.SetorRepository;
import com.pbd.sertaoprotocolo.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetorServiceImpl implements SetorService {

    @Autowired
    SetorRepository setorRepository;

    @Override
    public List<Setor> getSetors() {
        return setorRepository.findByAtivoBanco(true);
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
    public Setor updateSetor(Setor setor) {
        return setorRepository.save(setor);
    }

    @Override
    public Setor deleteSetor(Long id) {
        Setor setor = getSetor(id);
        setor.setAtivoBanco(false);
        updateSetor(setor);
        return setor;
    }

}
