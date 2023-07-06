package practice.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <회원 도메인 테스트>
 */
public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("회원 가입 테스트")
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
