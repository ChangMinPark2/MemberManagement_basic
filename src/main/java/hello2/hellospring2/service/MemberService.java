package hello2.hellospring2.service;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.repository.MemberRepository;
import hello2.hellospring2.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입 메소드
    public long join(Member member) {

        long start = System.currentTimeMillis();
        //같은 이름이 있는 중복회원은 안된다. (기본키가 이름으로 만든 예를 든것)
        try{
            validateDuplicateMember(member);    // 중복회원검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");

        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    // 전체회원조회
    public List<Member> findMembers() {
        long start = System.currentTimeMillis();
        try{
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers = " + timeMs + "ms");

        }

    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
