package hello.helloSpring.sevice;

import hello.helloSpring.domain.Member;

import hello.helloSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void AfterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("hello");

        //when 이거를 실행했을 때
        Long saveId = memberService.join(member);

        //then 결과가 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("Spring1");

        Member member2 = new Member();
        member2.setName("Spring1");

        //when
        memberService.join(member1);
        IllegalAccessException e = assertThrows(IllegalAccessException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


       /* try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.")
        }
*/
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}