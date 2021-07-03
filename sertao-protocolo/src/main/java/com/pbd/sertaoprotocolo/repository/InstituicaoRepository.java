package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Instituicao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstituicaoRepository extends JpaRepository<Instituicao, Long> {
    Instituicao findByCnpj(String cnpj);

    List<Instituicao> findByAtivoBanco(boolean b);
}
