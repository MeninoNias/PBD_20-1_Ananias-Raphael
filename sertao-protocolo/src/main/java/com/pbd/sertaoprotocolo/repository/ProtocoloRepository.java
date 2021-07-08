package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.StatusProtocolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
    Long countAllBy();

    List<Protocolo> findAllByFuncionarioIdAndAtivoBanco(Long id, boolean b);
    List<Protocolo> findByAtivoBanco(boolean b);
    Integer countAllByStatus(StatusProtocolo statusProtocolo);
}
