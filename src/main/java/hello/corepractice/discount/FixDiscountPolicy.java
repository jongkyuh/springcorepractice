package hello.corepractice.discount;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // 스프링 빈 중복을 위해 fixDiscountPolicy도 빈 등록
@Qualifier("subDiscountPolicy")
@Primary
public class FixDiscountPolicy implements DiscountPolicy{

    private int disccountFixAmount = 1000; // 고정 VIP 할인 금액
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return disccountFixAmount;
        }else{
            return 0;
        }
    }
}
