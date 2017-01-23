package giraffe;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Guschcyna Olga
 * @version 1.0.0
 */
@Configuration
@ComponentScan("giraffe")
@EnableJpaRepositories("giraffe.repository")
@EntityScan("giraffe.domain")
public class SharedConfigurationReference { }
