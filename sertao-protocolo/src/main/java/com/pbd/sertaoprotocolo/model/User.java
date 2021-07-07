package com.pbd.sertaoprotocolo.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long>{

    @Column(name = "user_name")
    @Length(min = 5, message = "*Username deve ter pelo menos 5 caracteres")
    @NotEmpty(message = "*Por favor, preencha o campo username")
    private String userName;

    @Column(name = "email")
    @Email(message = "*Por favor, user um email valido")
    @NotEmpty(message = "*Por favor, preencha o campo email")
    private String email;

    @Column(name = "password")
    @Length(min = 5, message = "*Senha deve ter pelo menos 5 caracteres")
    @NotEmpty(message = "*Por favor, preencha o campo senha")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Column(name = "active")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Log> logs;

    public User (String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}