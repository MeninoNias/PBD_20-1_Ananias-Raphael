package com.pbd.sertaoprotocolo.configuracao;

import com.pbd.sertaoprotocolo.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String loginPage = "/login";
        String logoutPage = "/logout";

        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(loginPage).permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/forgot_password").permitAll()
//                .antMatchers("/home/**").hasAuthority("ADMIN")
                .antMatchers("/home/**").hasAnyAuthority("ADMIN", "USER_ADMIN")
                .antMatchers("/caros/**").hasAuthority("ADMIN")
                .antMatchers("/funcionarios/**").hasAuthority("ADMIN")
                .antMatchers("/instituicoes/**").hasAuthority("ADMIN")
                .antMatchers("/setores/**").hasAuthority("ADMIN")
                .antMatchers("/subsetores/**").hasAuthority("ADMIN")
                .antMatchers("/useres/**").hasAuthority("ADMIN")
                .antMatchers("/categorias/**").hasAuthority("ADMIN")
                .antMatchers("/home_user").hasAuthority("USER")
                .antMatchers("/protocolos/my_protocol/**").hasAnyAuthority("ADMIN", "USER_ADMIN", "USER")
                .antMatchers("/protocolos/new_protocolo/**").hasAnyAuthority("ADMIN", "USER_ADMIN", "USER")
                .antMatchers("/avisos/my_avisos/**").hasAnyAuthority("ADMIN", "USER_ADMIN", "USER")
                .antMatchers("/avisos/detail/**").hasAnyAuthority("ADMIN", "USER_ADMIN", "USER")
                .antMatchers("/avisos/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage(loginPage)
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/after_login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(logoutPage))
                .logoutSuccessUrl(loginPage).and().exceptionHandling();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/assetslogin/**", "/assets/**", "/assetshome/**");
    }

}
