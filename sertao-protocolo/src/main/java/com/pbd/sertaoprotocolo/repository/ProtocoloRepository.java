package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Protocolo;
import com.pbd.sertaoprotocolo.model.StatusProtocolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProtocoloRepository extends JpaRepository<Protocolo, Long> {
    Long countAllBy();

    List<Protocolo> findAllByFuncionarioIdAndAtivoBanco(Long id, boolean b);

    List<Protocolo> findByAtivoBanco(boolean b);

    @Query(value = "SELECT * FROM public.protocolo\n" +
            "ORDER BY id DESC LIMIT 10", nativeQuery = true)
    List<Protocolo> findLasts();

    Integer countAllByStatus(StatusProtocolo statusProtocolo);
}
