package noonbbara.REPLICA.service;

import jakarta.persistence.EntityManager;
import noonbbara.REPLICA.repository.ContentRepository;
import noonbbara.REPLICA.repository.JpaContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public ContentService contentService(){
        return new ContentService();
    }
    @Bean
    public ContentRepository contentRepository(){
        return new JpaContentRepository(em);
    }

}
