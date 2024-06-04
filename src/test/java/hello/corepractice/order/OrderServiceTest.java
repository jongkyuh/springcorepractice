package hello.corepractice.order;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import hello.corepractice.member.MemberService;
import hello.corepractice.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService =new OrderServiceImpl();

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);


    }

}
