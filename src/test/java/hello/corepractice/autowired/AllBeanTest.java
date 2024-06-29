package hello.corepractice.autowired;

import hello.corepractice.AutoAppConfig;
import hello.corepractice.discount.DiscountPolicy;
import hello.corepractice.discount.RateDiscountPolicy;
import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);

        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);

//        DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
//        Assertions.assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
//        int discount = bean.discount(member, 20000);
//        Assertions.assertThat(discount).isEqualTo(2000);



    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired // 생성자가 하나라 생략 가능하다.
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
