package hello.corepractice.discount;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip회원은 10프로 할인된 금액을 받아야 한다")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("vip가 아닌 회원은 할인된 금액이 나오면 안된다")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberBASIC", Grade.Basic);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);       // 일반회원이기때문에 0이 나와야 한다.
    }

}