package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Long> {
    List<Setor> findByAtivoBanco(boolean b);
}
