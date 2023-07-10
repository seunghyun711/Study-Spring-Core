package practice.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.core.AppConfig;

/**
 * <회원 도메인 테스트>
 */
public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach // 각 테스트 실행 전 호출되도록 하는 애너테이션
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
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
