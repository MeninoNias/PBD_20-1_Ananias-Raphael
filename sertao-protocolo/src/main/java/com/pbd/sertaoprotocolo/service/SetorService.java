package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Setor;

import java.util.List;

public interface SetorService {

    List<Setor> getSetors();
    Setor getSetor(Long id);
    Setor createSetor(Setor setor);
    Setor updateSetor(Long id, Setor setor);
    Setor deleteSetor(Long id);

}
