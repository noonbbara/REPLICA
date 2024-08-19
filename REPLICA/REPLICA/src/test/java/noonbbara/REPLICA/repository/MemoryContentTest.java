package noonbbara.REPLICA.repository;

import noonbbara.REPLICA.domain.Content;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MemoryContentTest {
    ContentRepository repository = new MemoryContentRepository();
    @Test
    public void save(){
        Content content = new Content();
        content.setMusic("21세기의 어떤날");

        repository.save(content);
        Content result = repository.findById(content.getId()).get();
        Assertions.assertThat(content).isEqualTo(result);

    }

    @Test
    public void findByMusic(){
        Content content1 = new Content();
        content1.setMusic("21세기의 어떤날");
        repository.save(content1);

        Content result = repository.findByMusic("21세기의 어떤날").get();
        Assertions.assertThat(result).isEqualTo(content1);
    }
}
