package com.pbd.sertaoprotocolo.configuracao;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    private BCryptPasswordEncoder bCryptPasswordEncoder;



}
