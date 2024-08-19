package noonbbara.REPLICA.repository;

import noonbbara.REPLICA.domain.Content;

import java.util.List;
import java.util.Optional;

public interface ContentRepository {
    Content save(Content content);
    Optional<Content> findById(Long id);
    Optional<Content> findByMusic(String music);
    Optional<Content> findByArtist(String artist);
    Optional<Content> findByPlace(String place);
    List<Content> findAll();

}
