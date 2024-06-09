package hello.corepractice;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import hello.corepractice.member.MemberService;
import hello.corepractice.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// 순수 자바로 구현하기 위한 실행 클래스
public class MemberApp {
    public static void main(String[] args) {
      //  MemberService memberService = new MemberServiceImpl();

        // 기존 자바로 설정클래스에서 가져오는 방식일 떄
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 1. 스프링 컨테이너 생성 (AppConfig에 있는 환경설정 정보를 가지고 컨테이너에 객체생성하고 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. name은 기본적으로 등록한 메소드 이름으로 등록된다. 두번째 파마미터는 타입이다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);


        // 콘솔로 확인여부 출력
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());


    }
}
