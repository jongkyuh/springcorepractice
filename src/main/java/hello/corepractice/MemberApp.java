package hello.corepractice;

import hello.corepractice.member.Grade;
import hello.corepractice.member.Member;
import hello.corepractice.member.MemberService;
import hello.corepractice.member.MemberServiceImpl;


// 순수 자바로 구현하기 위한 실행 클래스
public class MemberApp {
    public static void main(String[] args) {
      //  MemberService memberService = new MemberServiceImpl();

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);


        // 콘솔로 확인여부 출력
        System.out.println("findMember = " + findMember.getName());
        System.out.println("member = " + member.getName());


    }
}
