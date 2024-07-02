package hello.corepractice.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
       // AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(NetworkClient.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //close 메소드를 쓰기위해서 위에 두가지 방법으로 빈 등록을 해야한다.
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            // 빈 등록 이후 초기화 하기 때문에 setUrl()메소드를 통해 url을 받아서 출력하지 못하고 null이 출력된다.
            return networkClient;
        }
    }
}
