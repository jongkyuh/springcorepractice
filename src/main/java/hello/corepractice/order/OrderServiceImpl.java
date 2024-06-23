package hello.corepractice.order;

import hello.corepractice.discount.DiscountPolicy;
import hello.corepractice.discount.FixDiscountPolicy;
import hello.corepractice.discount.RateDiscountPolicy;
import hello.corepractice.member.Member;
import hello.corepractice.member.MemberRepository;
import hello.corepractice.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

   // private MemberRepository memberRepository = new MemoryMemberRepository();
    //   아래 주석은 기존의 방식이다. 그러나 추상인터페이스에만 의존하는 것이 아닌 구현클래스에까지 의존하기 떄문에
    //   DIP뿐만 아니라 서비스 코드도 변경해야 하기에 OCP까지 위반하게 된다.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  // 고정 할인 일 때 적용
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //그냥 이렇게 바꾸기만 해도 된다.

    // 그래서 개선하기 위한 코드를 만든다. final은 무조건 값을 할당 해야하기때문에 final을 사용하지 않는다.
 //   private DiscountPolicy discountPolicy;
    // 이렇게 변경하면 인터페이스에만 의존하게 된다. 이대로 실행하게 된다면? 당연히 할당되지 못했기 떄문에 nullpointerexception발생한다.

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
