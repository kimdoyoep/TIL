package hello.helloSpring.repository;

import hello.helloSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member); // 회원 정보를 저장

    Optional<Member> findById(Long id); // 저장소에 있는 id를 찾아 올 수 있다

    Optional<Member> findByName(String name); // 저장소에 있는 name을 찾아 올 수 있다

    List<Member> findAll(); // 저장되어있는 모든 회원정보를 반환해준다
}
