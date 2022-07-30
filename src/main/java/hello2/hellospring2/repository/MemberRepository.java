package hello2.hellospring2.repository;

import hello2.hellospring2.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findById(long id);

    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저장된 회원정보를 모두 반환해준다.
}
