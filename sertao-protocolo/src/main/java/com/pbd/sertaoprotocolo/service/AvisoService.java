package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Aviso;

import java.util.List;

public interface AvisoService {

    List<Aviso> getAvisos();
    Aviso getAviso(Long id);
    Aviso createAviso(Aviso aviso);
    Aviso updateAviso(Long id, Aviso aviso);
    Aviso deleteCargo(Long id);

}
