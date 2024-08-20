package noonbbara.REPLICA;

import noonbbara.REPLICA.repository.*;
import noonbbara.REPLICA.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final ContentRepository contentRepository;
    @Autowired
    public SpringConfig(@Qualifier("springDataJpaContentRepository") ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Bean
    public ContentService contentService(){
        return new ContentService(contentRepository);
    }

}
