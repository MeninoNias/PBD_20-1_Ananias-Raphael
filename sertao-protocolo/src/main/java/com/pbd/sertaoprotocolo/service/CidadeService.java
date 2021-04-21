package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Cidade;

import java.util.List;

public interface CidadeService {

    List<Cidade> getCidades();
    Cidade getCidade(Long id);
    Cidade createCidade(Cidade cidade);
    Cidade updateCidade(Long id, Cidade cidade);
    Cidade deleteCidade(Long id);
}


