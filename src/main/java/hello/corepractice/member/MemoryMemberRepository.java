package hello.corepractice.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{


    // 동시성 이슈를 위해 ConcurrentHashMap을 구현하는게 맞지만 일단은 단순예제로 활용하기위해 HashMap 구현
    private static Map<Long,Member> store = new HashMap<>();


    // save 메소드(회원가입) 구현
    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
//