package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Protocolo;

import java.util.List;

public interface ProtocoloService {

    List<Protocolo> getProtocolos();
    Protocolo getProtocolo(Long id);
    Protocolo createProtocolo(Protocolo protocolo);
    Protocolo updateProtocolo(Long id, Protocolo protocolo);
    Protocolo deleteProtocolo(Long id);
}
