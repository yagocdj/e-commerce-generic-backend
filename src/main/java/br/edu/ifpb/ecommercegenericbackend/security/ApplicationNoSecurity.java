package br.edu.ifpb.ecommercegenericbackend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

/**
 * Class that "disables" Spring Security. It is important to note that this class
 * should be removed in the future so that a secure implementation can be realized.
 * The only reason for the existence of this class is the lack of time to implement
 * the rest of the project on time.
 * @author yago
 */

// FIXME - remove this class later
@Configuration
public class ApplicationNoSecurity {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().anyRequest();
    }
}
