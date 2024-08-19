package noonbbara.REPLICA.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContentServiceIntegrationTest {
    package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
    @SpringBootTest
    @Transactional //테스트를 실행하고나서 롤백을 해줌 (aftereach쓴거랑 비슷한 역할)
    public class MemberServiceIntegrationTest {

        @Autowired
        MemberService memberService;
        @Autowired
        MemberRepository memberRepository;

        @Test
        void join() {
            //given
            Member member = new Member();
            member.setName("spring000");

            //when
            Long saveId = memberService.join(member);

            //then
            Member findMember = memberService.findOne(saveId).get();
            assertThat(member.getName()).isEqualTo(findMember.getName());
        }

        @Test
        public void 중복회원예외(){
            //given
            Member member1 = new Member();
            member1.setName("spring");

            Member member2 = new Member();
            member2.setName("spring");
            //when
            memberService.join(member1);
//        try{
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.124");
//        }
            IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
            //then
        }

        @Test
        void findMembers() {
        }

        @Test
        void findOne() {
        }
    }
}