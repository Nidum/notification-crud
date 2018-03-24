package sticker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by Emiliia Nesterovych on 3/19/2018.
 */
@Configuration
public class HibernateConfig {

    @Bean
    public EntityManager entityManager() {
        return Persistence.createEntityManagerFactory("sticker").createEntityManager();
    }

}
