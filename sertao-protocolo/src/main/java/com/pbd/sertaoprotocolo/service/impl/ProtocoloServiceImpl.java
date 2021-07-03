package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.repository.ProtocoloRepository;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProtocoloServiceImpl implements ProtocoloService {

    @Autowired
    ProtocoloRepository protocoloRepository;

    @Override
    public List<Protocolo> getProtocolos() {
        return protocoloRepository.findByAtivoBanco(true);
    }

    @Override
    @Transactional
    public List<Protocolo> getProtocolosByFuncionarios(Funcionario funcionario) {
        return protocoloRepository.findAllByFuncionarioIdAndAtivoBanco(funcionario.getId(), true);
    }

    @Override
    public Long contAll() {
        return protocoloRepository.countAllBy();
    }

    @Override
    @Transactional
    public Protocolo getProtocolo(Long id) {
        return protocoloRepository.findById(id).get();
    }

    @Override
    public Protocolo createProtocolo(Protocolo protocolo) {
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Protocolo updateProtocolo(Protocolo protocolo) {
        return protocoloRepository.save(protocolo);
    }

    @Override
    public Protocolo deleteProtocolo(Long id) {
        Protocolo protocolo = getProtocolo(id);
        protocolo.setAtivoBanco(false);
        updateProtocolo(protocolo);
        return protocolo;
    }

}
