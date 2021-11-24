package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long Join(Member member){

        validateMember(member);

        memberRepository.save(member);

        return member.getId();

    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){

       return memberRepository.findAll();

    }

    /**
     * 회원 아이디 찾기
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);

    }



    private void validateMember(Member member) {
        memberRepository.findByName(member.getName())
              .ifPresent(m -> {
           throw new IllegalStateException("이미 존재하는 회원입니다");
              });
    }
}
