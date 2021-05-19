package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Endereco;
import com.pbd.sertaoprotocolo.repository.EnderecoRepository;
import com.pbd.sertaoprotocolo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> getEnderecos() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco getEndereco(Long id) {
        return enderecoRepository.findById(id).get();
    }

    @Override
    public Endereco createEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco updateEndereco(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @Override
    public Endereco deleteEndereco(Long id) {
        return null;
    }
}
