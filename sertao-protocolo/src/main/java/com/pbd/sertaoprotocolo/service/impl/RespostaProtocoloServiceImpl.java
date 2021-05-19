package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.RespostaProtocolo;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.repository.RespostaProtocoloRepository;
import com.pbd.sertaoprotocolo.service.RespostaProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RespostaProtocoloServiceImpl implements RespostaProtocoloService {

    @Autowired
    RespostaProtocoloRepository repostaProtocoloRepository;

    @Override
    public List<RespostaProtocolo> getRespostaProtocolos() {
        return repostaProtocoloRepository.findAll();
    }

    @Override
    public RespostaProtocolo getRespostaProtocolo(Long id) {
        return repostaProtocoloRepository.findById(id).get();
    }

    @Override
    public RespostaProtocolo createRespostaProtocolo(RespostaProtocolo repostaProtocolo) {
        return repostaProtocoloRepository.save(repostaProtocolo);
    }

    @Override
    public RespostaProtocolo updateRespostaProtocolo(RespostaProtocolo repostaProtocolo) {
        return repostaProtocoloRepository.save(repostaProtocolo);
    }

    @Override
    public RespostaProtocolo deleteRespostaProtocolo(Long id) {
        return null;
    }
}
