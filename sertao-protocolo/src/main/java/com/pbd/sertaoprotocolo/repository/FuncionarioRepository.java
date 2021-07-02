package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByMatricula(String matricula);
    List<Funcionario> findFuncionariosByAtivoBanco(boolean b);
}
