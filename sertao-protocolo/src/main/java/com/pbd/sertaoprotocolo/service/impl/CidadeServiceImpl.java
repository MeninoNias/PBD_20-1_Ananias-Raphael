package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Cidade;
import com.pbd.sertaoprotocolo.repository.CidadeRepository;
import com.pbd.sertaoprotocolo.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeServiceImpl implements CidadeService {

    @Autowired
    CidadeRepository cidadeRepository;

    @Override
    public List<Cidade> getCidades() {
        return cidadeRepository.findAll();
    }

    @Override
    public Cidade getCidade(Long id) {
        return cidadeRepository.findById(id).get();
    }

    @Override
    public Cidade createCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    @Override
    public Cidade updateCidade(Long id, Cidade cidade) {
        Cidade c = cidadeRepository.findById(id).get();
        c.setNome(cidade.getNome());
        cidadeRepository.save(c);
        return c;
    }

    @Override
    public Cidade deleteCidade(Long id) {
        return null;
    }

}
