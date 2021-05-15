package com.pbd.sertaoprotocolo.service;

import com.pbd.sertaoprotocolo.model.Instituicao;

import java.util.List;

public interface InstituicaoService {
    List<Instituicao> getInstituicaos();
    Instituicao getInstituicaoCNPJ(String cnpj);
    Instituicao getInstituicao(Long id);
    Instituicao createInstituicao(Instituicao instituicao);
    Instituicao updateInstituicao(Long id, Instituicao instituicao);
    Instituicao deleteInstituicao(Long id);
}
