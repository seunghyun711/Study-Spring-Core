package practice.core.member;

import java.util.HashMap;
import java.util.Map;

/**
 * 메모리 회원 저장
 * MemberRepository인터페이스의 구현 클래스
 */
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); // 회원 정보를 저장할 hashmap
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
