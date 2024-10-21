package com.example.gestionstage;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
@AllArgsConstructor
public class GestionStageApplication {
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(GestionStageApplication.class, args);


    }
    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
        return args -> {
            UserDetails u1=jdbcUserDetailsManager.loadUserByUsername("admin");
            if(u1==null)
                jdbcUserDetailsManager.createUser(
                        User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("ADMIN").build()
                );

        };
    }


}
