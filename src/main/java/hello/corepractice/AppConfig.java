package hello.corepractice;

import hello.corepractice.discount.FixDiscountPolicy;
import hello.corepractice.member.MemberService;
import hello.corepractice.member.MemberServiceImpl;
import hello.corepractice.member.MemoryMemberRepository;
import hello.corepractice.order.OrderService;
import hello.corepractice.order.OrderServiceImpl;

public class AppConfig {

    // 생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    // 생성자 주입
    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
