package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Aviso;
import com.pbd.sertaoprotocolo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
    List<Aviso> findAllByFuncionarios(Funcionario funcionario);
    List<Aviso> findByAtivoBanco(boolean b);
}
