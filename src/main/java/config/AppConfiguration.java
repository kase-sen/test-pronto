package config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * The type App configuration.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditor")
public class AppConfiguration {

    /**
     * Model mapper model mapper.
     *
     * @return the model mapper
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Auditor auditor aware.
     *
     * @return the auditor aware
     */
    @Bean
    public AuditorAware<String> auditor() {
        return () -> Optional.of("Administrator");
    }


}
