package hello.corepractice.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

  //  private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 생성자를 통해서 주입한다
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 메소드 구현
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
