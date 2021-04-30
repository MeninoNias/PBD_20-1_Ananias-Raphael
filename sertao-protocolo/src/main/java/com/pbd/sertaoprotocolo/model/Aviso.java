package com.pbd.sertaoprotocolo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aviso extends AbstractEntity<Long>{

    @Column(name = "titulo")
    @NotEmpty(message = "*Por favor, preencha o campo titulo")
    private String titulo;

    @Lob
    @Column(name = "descricao")
    @NotEmpty(message = "*Por favor, preencha o campo descrição")
    private String descricao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "func_aviso", joinColumns = @JoinColumn(name = "aviso_id"), inverseJoinColumns = @JoinColumn(name = "func_id"))
    private List<Funcionario> funcionarios;
}
