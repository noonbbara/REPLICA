package noonbbara.REPLICA.service;

import noonbbara.REPLICA.domain.Content;
import noonbbara.REPLICA.repository.ContentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


    @SpringBootTest
    @Transactional //테스트를 실행하고나서 롤백을 해줌 (aftereach쓴거랑 비슷한 역할)
    public class ContentServiceIntegrationTest {

        @Autowired
        ContentService contentService;
        @Autowired
        ContentRepository contentRepository;

        @Test
        void music() {
            //given
            Content content = new Content();
            content.setMusic("21세기");

            //when
            Long saveId = contentService.write(content);

            //then
            Content findContent = contentRepository.findById(saveId).get();
            assertThat(content.getMusic()).isEqualTo(findContent.getMusic());
        }


        @Test
        void findMembers() {
        }

        @Test
        void findOne() {
        }
    }

