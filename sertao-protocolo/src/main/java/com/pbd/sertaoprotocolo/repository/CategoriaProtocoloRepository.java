package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.CategoriaProtocolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProtocoloRepository extends JpaRepository<CategoriaProtocolo, Long> {
    CategoriaProtocolo findByNome(String nome);
}
