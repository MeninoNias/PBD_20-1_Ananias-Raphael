package com.pbd.sertaoprotocolo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
@Setter
@Entity
@Table(name = "enderecos")
public class Endereco extends AbstractEntity<Long>{

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_cidade_fk")
    private Cidade cidade;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column(nullable = false, length = 5)
    private Integer numero;

    private String complemento;

    @Column(nullable = false, length = 9)
    private String cep;

}
