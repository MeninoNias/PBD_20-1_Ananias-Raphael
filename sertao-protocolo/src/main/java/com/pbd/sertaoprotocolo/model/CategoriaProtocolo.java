package com.pbd.sertaoprotocolo.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CategoriaProtocolo extends AbstractEntity<Long> {

    @Column(name = "nome")
    @NotEmpty(message = "*Por favor, preencha o campo nome")
    private String nome;

    @Column(name = "abreviacao")
    @Length(max = 4, message = "Deve conter no maximo 4 caracteres")
    @NotEmpty
    private String abreviacao;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Protocolo> protocolos;

}
