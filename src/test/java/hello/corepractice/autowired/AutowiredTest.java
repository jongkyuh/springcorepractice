package hello.corepractice.autowired;

import hello.corepractice.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false)// 의존관계라 없으면 setNoBean1 자체가 호출이 안된다
        public void setNoBean1(Member bean1){
            System.out.println("bean1 = " + bean1);
        }

        @Autowired // 호출 자체는 된다. 대신에 null이 출력된다.
        public void setNoBean2(@Nullable Member bean2){
            System.out.println("bean2 = " + bean2);
        }

        @Autowired // 빈이 없으면 Optional.empty
        public void setNoBean3(Optional<Member> bean3){
            System.out.println("bean3 = " + bean3);
        }
    }
}
