package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Protocolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
    Long countAllBy();

    List<Protocolo> findAllByFuncionarioId(Long id);
}
