package com.pbd.sertaoprotocolo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cidades")
public class Cidade extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false)
    private String nome;


}
