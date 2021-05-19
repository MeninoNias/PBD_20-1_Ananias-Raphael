package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.Protocolo;

import java.util.List;

public interface ProtocoloService {

    List<Protocolo> getProtocolos();

    List<Protocolo> getProtocolosByFuncionarios(Funcionario funcionario);

    Long contAll();

    Protocolo getProtocolo(Long id);

    Protocolo createProtocolo(Protocolo protocolo);

    Protocolo updateProtocolo(Protocolo protocolo);

    Protocolo deleteProtocolo(Long id);
}
