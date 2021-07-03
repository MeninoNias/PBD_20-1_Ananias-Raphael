package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.SubSetor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubSetorRepository extends JpaRepository<SubSetor, Long> {
    List<SubSetor> findByAtivoBanco(boolean b);
}

