package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Funcionario;
import com.pbd.sertaoprotocolo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByMatricula(String matricula);
}
