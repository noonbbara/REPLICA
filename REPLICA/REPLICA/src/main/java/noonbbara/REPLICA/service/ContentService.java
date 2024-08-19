package noonbbara.REPLICA.service;

import noonbbara.REPLICA.domain.Content;
import noonbbara.REPLICA.repository.ContentRepository;
import noonbbara.REPLICA.repository.MemoryContentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ContentService {
    private final ContentRepository contentRepository = new MemoryContentRepository();
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
