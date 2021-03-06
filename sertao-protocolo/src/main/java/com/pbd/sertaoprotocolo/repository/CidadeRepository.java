package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByAtivoBanco(boolean b);
}
