package hello.corepractice;

import hello.corepractice.member.MemberRepository;
import hello.corepractice.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 기존 AppConfig와 같은 예제코드를 중복으로 스프링빈으로 등록하지 않기 위해서 제외시켜준다. 그래야 나중에
                    // 복습할 때에도 실행 가능하기 위해서
    //    basePackages = "hello.corepractice",
    //    basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean("memoryMemberRepository")
//        // 테스트를 통해서 빈등록을 하게되면 같은 이름이 있더라도 수동빈이 우선권을 갖게되어
//        // 자동빈을 오버라이딩 해버린다.
//        // 스프링 부트를 실행하게되면 오류가 난다.
//
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
