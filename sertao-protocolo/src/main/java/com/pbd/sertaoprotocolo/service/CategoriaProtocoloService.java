package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.CategoriaProtocolo;

import java.util.List;

public interface CategoriaProtocoloService {

    List<CategoriaProtocolo> getCategoriaProtocolos();
    CategoriaProtocolo getCategoriaProtocolo(Long id);
    CategoriaProtocolo createCategoriaProtocolo(CategoriaProtocolo categoriaProtocolo);
    CategoriaProtocolo updateCategoriaProtocolo(Long id, CategoriaProtocolo categoriaProtocolo);
    CategoriaProtocolo deleteCategoriaProtocolo(Long id);
}
