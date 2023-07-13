package practice.core.member;

/**
 * MemberService 구현 클래스
 */
public class MemberServiceImpl implements MemberService {
//    private final MemberRepository memberRepository = new MemoryMemberRepository(); // MemberRepository의 구현 클래스인 MemoryMemberRepository클래스를 의존
    private final MemberRepository memberRepository;

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) { // 회원 가입
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) { // 회원 찾기
        return memberRepository.findById(memberId);
    }
}
