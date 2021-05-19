package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.Funcionario;

import java.util.List;

public interface AvisoService {

    List<Aviso> getAvisos();

    List<Aviso> getAvisosFuncionarios(Funcionario funcionario);

    Aviso getAviso(Long id);

    Aviso createAviso(Aviso aviso);

    Aviso updateAviso(Aviso aviso);

    Aviso deleteAviso(Long id);

}
