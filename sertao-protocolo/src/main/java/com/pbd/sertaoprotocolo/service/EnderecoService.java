package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Endereco;

import java.util.List;

public interface EnderecoService {

    List<Endereco> getEnderecos();

    Endereco getEndereco(Long id);

    Endereco createEndereco(Endereco endereco);

    Endereco updateEndereco(Endereco endereco);

    Endereco deleteEndereco(Long id);
}
