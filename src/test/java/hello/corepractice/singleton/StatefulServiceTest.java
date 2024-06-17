package hello.corepractice.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);

        // ThreadA: 사용자A 주문금액조회
      //  int price = statefulService1.getPrice();
       // System.out.println("price = " + price);     // 공유필드를 바꿨기 때문에 userA가 주문한 가격이 정확히 나오지 않음(10000이 아니라 20000 이 나옴)

        System.out.println("userAPrice = " + userAPrice);
        System.out.println("userBPrice = " + userBPrice);

    //    Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);    // 테스트로 다시 확인
    }




    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}