package com.example.Ejerciciossesiones789.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/ordenadores").permitAll()
                //.antMatchers("/ordenadore/{id}").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    @Bean
    public HttpFirewall looseHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);
        firewall.setAllowSemicolon(true);
        return firewall;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //enable in memory based authentication with a user named
        // "user" and "admin"
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncode())
                .withUser("user").password(passwordEncode().encode("password6")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncode().encode("password25")).roles("USER", "ADMIN");
    }

    public PasswordEncoder passwordEncode() {
        return new BCryptPasswordEncoder();
    }
}



    /** @Bean
     @Override
     public UserDetailsService userDetailsServiceBean() throws Exception {
     return super.userDetailsServiceBean();
     }

}

    }
}*/
