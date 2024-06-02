package hello.corepractice.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


//MemberServiceImpl에 대한 테스트 코드
public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();


    // 가입이 정상적으로 작동하였는지에 대한 테스트 코드
    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);


    }
}
