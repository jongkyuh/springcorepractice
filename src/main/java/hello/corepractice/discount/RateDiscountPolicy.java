package hello.corepractice.discount;

import hello.corepractice.annotation.MainDiscountPolicy;
import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy // 직접 만들 애노테이션을 사용
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
