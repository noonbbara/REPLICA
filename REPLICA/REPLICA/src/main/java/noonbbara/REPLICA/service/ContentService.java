package noonbbara.REPLICA.service;

import noonbbara.REPLICA.domain.Content;
import noonbbara.REPLICA.repository.ContentRepository;
import noonbbara.REPLICA.repository.MemoryContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ContentService {
    private ContentRepository contentRepository = new MemoryContentRepository();

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    // 컨텐츠 작성
    public Long write(Content content){
        contentRepository.save(content);
        return content.getId();
    }
    // 전체 컨텐츠 조회
    public List<Content> findContents(){
        return contentRepository.findAll();
    }

}
