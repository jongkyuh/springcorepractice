package hello.corepractice.member;

// 회원기능  MemberRepository 인터페이스
public interface MemberRepository {

    // 회원가입 메소드
    void save(Member member);

    // 회원id로 찾기위한 메소드
    Member findById(Long memberId);


}
