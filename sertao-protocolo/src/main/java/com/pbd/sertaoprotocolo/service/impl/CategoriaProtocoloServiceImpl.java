package com.pbd.sertaoprotocolo.service.impl;

import com.pbd.sertaoprotocolo.model.CategoriaProtocolo;
import com.pbd.sertaoprotocolo.repository.CategoriaProtocoloRepository;
import com.pbd.sertaoprotocolo.service.CategoriaProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProtocoloServiceImpl implements CategoriaProtocoloService {

    @Autowired
    CategoriaProtocoloRepository categoriaRepository;

    @Override
    public List<CategoriaProtocolo> getCategoriaProtocolos() {
        return categoriaRepository.findAll();
    }

    @Override
    public CategoriaProtocolo getCategoriaProtocolo(Long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public CategoriaProtocolo getCategoriaProtocoloNome(String categoria) {
        return categoriaRepository.findByNome(categoria);
    }

    @Override
    public CategoriaProtocolo createCategoriaProtocolo(CategoriaProtocolo categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public CategoriaProtocolo updateCategoriaProtocolo(Long id, CategoriaProtocolo categoria) {
        CategoriaProtocolo c = categoriaRepository.findById(id).get();
        return c;
    }

    @Override
    public CategoriaProtocolo deleteCategoriaProtocolo(Long id) {
        return null;
    }

}
