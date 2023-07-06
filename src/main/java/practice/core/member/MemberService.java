package practice.core.member;

/**
 * <회원 서비스>
 */
public interface MemberService {
    void join(Member member); // 회원 가입

    Member findMember(Long memberId); // 회원 찾기
}
