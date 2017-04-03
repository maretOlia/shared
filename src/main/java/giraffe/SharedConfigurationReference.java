package giraffe;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Olga Gushchyna
 * @version 0.0.1
 */
@Configuration
@ComponentScan("giraffe")
@EnableJpaRepositories("giraffe.repository")
@EntityScan("giraffe.domain")
public class SharedConfigurationReference {

    @Bean
    @Qualifier("bCryptPasswordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
