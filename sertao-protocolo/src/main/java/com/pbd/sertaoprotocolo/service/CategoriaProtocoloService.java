package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.CategoriaProtocolo;

import java.util.List;

public interface CategoriaProtocoloService {

    List<CategoriaProtocolo> getCategoriaProtocolos();

    CategoriaProtocolo getCategoriaProtocolo(Long id);

    CategoriaProtocolo getCategoriaProtocoloNome(String categoria);

    CategoriaProtocolo createCategoriaProtocolo(CategoriaProtocolo categoriaProtocolo);

    CategoriaProtocolo updateCategoriaProtocolo(CategoriaProtocolo categoriaProtocolo);

    CategoriaProtocolo deleteCategoriaProtocolo(Long id);
}
