package noonbbara.REPLICA.repository;

import noonbbara.REPLICA.domain.Content;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryContentRepository implements ContentRepository{
    private static Map<Long, Content> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Content save(Content content) {
        content.setId(++sequence);
        store.put(content.getId(), content);
        return content;
    }

    @Override
    public Optional<Content> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Content> findByMusic(String music) {
        return store.values().stream()
                .filter(content -> content.getMusic().equals(music))
                .findAny();
    }

    @Override
    public Optional<Content> findByArtist(String artist) {
        return store.values().stream()
                .filter(content -> content.getArtist().equals(artist))
                .findAny();
    }

    @Override
    public Optional<Content> findByPlace(String place) {
        return store.values().stream()
                .filter(content -> content.getPlace().equals(place))
                .findAny();
    }

    @Override
    public List<Content> findAll() {
        return new ArrayList<>(store.values());
    }
}
