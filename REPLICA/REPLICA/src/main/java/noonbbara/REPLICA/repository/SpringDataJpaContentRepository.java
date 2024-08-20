package noonbbara.REPLICA.repository;

import noonbbara.REPLICA.domain.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaContentRepository extends JpaRepository<Content, Long>, ContentRepository {
    @Override
    Optional<Content> findByMusic(String music);
}
