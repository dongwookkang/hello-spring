package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository =new MemoryMemberRepository();

    @AfterEach
    public void  afterEach(){
        repository.clearStore();

    }

    @Test
    public void  save(){
        Member member = new Member();
        member.setName("강동욱");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1 =new Member();
        member1.setName("강동욱");
        repository.save(member1);

        Member member2 =new Member();
        member1.setName("강동수");
        repository.save(member2);

        Member result  = repository.findByName("강동수").get();
        assertThat(result).isEqualTo(member2);

    }

}
