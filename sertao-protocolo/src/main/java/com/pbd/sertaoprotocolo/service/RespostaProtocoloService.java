package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.RespostaProtocolo;

import java.util.List;

public interface RespostaProtocoloService {

    List<RespostaProtocolo> getRespostaProtocolos();

    RespostaProtocolo getRespostaProtocolo(Long id);

    RespostaProtocolo createRespostaProtocolo(RespostaProtocolo aviso);

    RespostaProtocolo updateRespostaProtocolo(RespostaProtocolo aviso);

    RespostaProtocolo deleteRespostaProtocolo(Long id);
}
