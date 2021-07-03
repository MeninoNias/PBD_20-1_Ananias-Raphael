package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.RespostaProtocolo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaProtocoloRepository extends JpaRepository<RespostaProtocolo, Long> {
    RespostaProtocolo findTopByProtocoloId(Long id);
    List<RespostaProtocolo> findByAtivoBanco(boolean b);
}
