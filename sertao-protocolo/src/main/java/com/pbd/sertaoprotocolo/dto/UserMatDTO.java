package com.pbd.sertaoprotocolo.dto;

import com.pbd.sertaoprotocolo.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserMatDTO {

    private String userName;
    private String email;
    private String password;
    private String matricula;

    public User transformaParaObjeto(){
        return new User(userName, email, password);
    }

}
