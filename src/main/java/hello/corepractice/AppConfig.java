package hello.corepractice;

import hello.corepractice.discount.DiscountPolicy;
import hello.corepractice.discount.FixDiscountPolicy;
import hello.corepractice.discount.RateDiscountPolicy;
import hello.corepractice.member.MemberService;
import hello.corepractice.member.MemberServiceImpl;
import hello.corepractice.member.MemoryMemberRepository;
import hello.corepractice.order.OrderService;
import hello.corepractice.order.OrderServiceImpl;

public class AppConfig {

    // 기존 코드에서는 AppConfig 클래스의 코드만을 보고 어떤역할을 하는지에 대한 것을 보기가 어렵다 그래서 분리해야한다. 
    
    // 생성자 주입
    
//    //기존 코드 
//    public MemberService memberService(){        
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
    
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 생성자 주입

    //기존코드

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    //FixDiscountPolicy은 자동완성을 사용하지않고 적용
//    public DiscountPolicy discountPolicy(){ // 고정할인정책
//        return new FixDiscountPolicy();
//    }


    // 정률할인 정책으로 변경
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
