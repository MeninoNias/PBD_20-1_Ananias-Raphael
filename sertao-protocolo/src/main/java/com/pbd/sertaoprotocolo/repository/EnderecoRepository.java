package com.pbd.sertaoprotocolo.repository;

import com.pbd.sertaoprotocolo.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByAtivoBanco(boolean b);
}
