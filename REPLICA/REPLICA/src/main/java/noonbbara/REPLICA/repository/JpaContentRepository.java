package noonbbara.REPLICA.repository;

import jakarta.persistence.EntityManager;
import noonbbara.REPLICA.domain.Content;

import java.util.List;
import java.util.Optional;

public class JpaContentRepository implements ContentRepository {

    public JpaContentRepository(EntityManager em) {
        this.em = em;
    }

    private final EntityManager em;
    @Override
    public Content save(Content content) {
        em.persist(content);
        return content;
    }

    @Override
    public Optional<Content> findById(Long id) {
        Content content = em.find(Content.class, id);
        return Optional.ofNullable(content);
    }
    @Override
    public Optional<Content> findByMusic(String music) {
        List<Content> result = em.createQuery("select c from Content c where c.music = :music", Content.class)
                .setParameter("music", music)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Content> findByArtist(String artist) {
        List<Content> result = em.createQuery("select c from Content c where c.artist = :artist", Content.class)
                .setParameter("artist", artist)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public Optional<Content> findByPlace(String place) {
        List<Content> result = em.createQuery("select c from Content c where c.place = :place", Content.class)
                .setParameter("place", place)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Content> findAll() {
        List<Content> result = em.createQuery("select c from Content c", Content.class)
                .getResultList();
        return result;
    }
}
