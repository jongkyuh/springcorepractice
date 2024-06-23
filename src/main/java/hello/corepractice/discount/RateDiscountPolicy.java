package hello.corepractice.discount;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10; //10퍼센트 할인
    @Override       // ctrl shift t  단축키를 통해 바로 테스트 코드를 만든다.
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
