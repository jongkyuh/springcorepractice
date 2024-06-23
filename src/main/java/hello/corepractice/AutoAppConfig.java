package hello.corepractice;

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
}
