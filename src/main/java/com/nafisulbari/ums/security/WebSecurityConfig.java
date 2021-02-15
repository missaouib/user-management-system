package com.nafisulbari.ums.security;

import com.nafisulbari.ums.persistence.dao.PrivilegeRepository;
import com.nafisulbari.ums.persistence.model.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    PrivilegeRepository privilegeRepository;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //setAuthorityToUrls(http);

        http
                .authorizeRequests()
//                .antMatchers("/", "/registration").permitAll()
//                .antMatchers("/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll().successForwardUrl("/")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }


    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }


    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**");
    }


    private void setAuthorityToUrls(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> {
            for (Privilege privilege : privilegeRepository.findAll()) {
                String privilegeUrl = privilege.getUrl();
                requests.antMatchers(privilegeUrl).hasAuthority(privilegeUrl);
            }
        });
    }


}
