package hello.corepractice.member;


// 회원기능  MemberService 인터페이스
public interface MemberService {


    // 가입 메소드
    void join(Member member);

    // id로 회원정보 조회 메소드
    Member findMember(Long memberId);
}
