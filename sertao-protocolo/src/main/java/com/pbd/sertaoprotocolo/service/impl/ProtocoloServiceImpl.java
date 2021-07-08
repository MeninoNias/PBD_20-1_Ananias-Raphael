package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.export.FuncionarioExport;
import com.pbd.sertaoprotocolo.export.ProtocoloExport;
import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.StatusProtocolo;
import com.pbd.sertaoprotocolo.repository.ProtocoloRepository;
import com.pbd.sertaoprotocolo.service.ProtocoloService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProtocoloServiceImpl implements ProtocoloService {

    @Autowired
    ProtocoloRepository protocoloRepository;

    private ProtocoloExport protocoloExport;



    @Override
    @Transactional
    public List<Protocolo> getProtocolos() {
        return protocoloRepository.findByAtivoBanco(true);
    }

    @Override
    @Transactional
    public List<Protocolo> getLastsProtocolos() {
        return protocoloRepository.findLasts();
    }

    @Override
    @Transactional
    public List<Protocolo> getProtocolosByFuncionarios(Funcionario funcionario) {
        return protocoloRepository.findAllByFuncionarioIdAndAtivoBanco(funcionario.getId(), true);
    }

    @Override
    public List<Integer> getContProtocolos() {
        List<Integer> list = new ArrayList<>();
        list.add(protocoloRepository.countAllByStatus(StatusProtocolo.RE));
        list.add(protocoloRepository.countAllByStatus(StatusProtocolo.PE));
        list.add(protocoloRepository.countAllByStatus(StatusProtocolo.CA));
        return list;
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

    @Override
    public XSSFWorkbook exportExel() {
        protocoloExport = new ProtocoloExport();
        protocoloExport.exelCabelcalho();
        protocoloExport.popularLinhas(getProtocolos());

        return protocoloExport.getWorkbook();
    }

}
