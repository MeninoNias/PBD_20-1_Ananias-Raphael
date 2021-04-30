package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.repository.ProtocoloRepository;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProtocoloServiceImpl implements ProtocoloService {

    @Autowired
    ProtocoloRepository protocoloRepository;

    @Override
    public List<Protocolo> getProtocolos() {
        return protocoloRepository.findAll();
    }

    @Override
    public Protocolo getProtocolo(Long id) {
        return protocoloRepository.findById(id).get();
    }

    @Override
    public Protocolo createProtocolo(Protocolo protocolo) {
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Protocolo updateProtocolo(Long id, Protocolo protocolo) {
        Protocolo c = protocoloRepository.findById(id).get();

        return c;
    }

    @Override
    public Protocolo deleteProtocolo(Long id) {
        return null;
    }

}
