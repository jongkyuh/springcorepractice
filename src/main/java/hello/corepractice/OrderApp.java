package hello.corepractice;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import hello.corepractice.member.MemberService;
import hello.corepractice.member.MemberServiceImpl;
import hello.corepractice.order.Order;
import hello.corepractice.order.OrderService;
import hello.corepractice.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        // 기존 자바로 설정클래스에서 가져오는 방식일 떄
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        // 1. 스프링 컨테이너 생성 (AppConfig에 있는 환경설정 정보를 가지고 컨테이너에 객체생성하고 관리해준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. name은 기본적으로 등록한 메소드 이름으로 등록된다. 두번째 파마미터는 타입이다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId =1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 30000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        
    }
}
