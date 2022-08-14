package hello2.hellospring2.repository;

import hello2.hellospring2.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPOL select m from member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); 
}
