package hello.corepractice.discount;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;

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
