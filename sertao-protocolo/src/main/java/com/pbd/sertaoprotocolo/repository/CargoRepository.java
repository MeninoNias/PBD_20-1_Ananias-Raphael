package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    Cargo findByNome(String nome);
    List<Cargo> findByAtivoBanco(boolean b);
}
