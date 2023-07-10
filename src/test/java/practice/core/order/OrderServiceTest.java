package practice.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice.core.AppConfig;
import practice.core.member.Grade;
import practice.core.member.Member;
import practice.core.member.MemberService;
import practice.core.member.MemberServiceImpl;

/**
 * <주문 및 할인 정책 테스트>
 */
public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach // 각 테스트 실행 전 호출되도록 하는 애너테이션
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    @DisplayName("주문 및 할인 정책 테스트")
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP); // 등급인 VIP인 memberA라는 회원
        memberService.join(member); // 회원 가입

        Order order = orderService.createOrder(memberId, "itemA", 10000); // 주문 생성
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000); // 할인된 금액이 1000원이 맞는지 검증
    }
}
