package com.pbd.sertaoprotocolo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
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
    @JoinTable(name = "func_aviso", joinColumns = @JoinColumn(name = "aviso_id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
    private List<Funcionario> funcionarios;
}
