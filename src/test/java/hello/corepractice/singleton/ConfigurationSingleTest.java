package hello.corepractice.singleton;

import hello.corepractice.AppConfig;
import hello.corepractice.member.MemberRepository;
import hello.corepractice.member.MemberServiceImpl;
import hello.corepractice.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingleTest {

    @Test
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        // getMemberRepository() 메소드를 사용하기위해 구체클래스로 가져온다.
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void confiugurationDeep(){
        
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());

        // 출력결과가 bean.getClass() = class hello.corepractice.AppConfig가 아니라
        // bean.getClass() = class hello.corepractice.AppConfig$$SpringCGLIB$$0 로 나오게 된다.
        // 순수한 자바 클래스인 AppCofig 클래스를 싱글톤으로 관리하기 위해 AppConfig를 상속받은 임의의 클래스를 만들어
        // 이 클래스를 스프링에 등록한 것이다. 그래서 부모타입인 AppConfig.class로 조회가 가능하다.
    }
}
