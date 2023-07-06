package practice.core.discount;

import practice.core.member.Member;

/**
 * <할인 정책 인터페이스>
 */
public interface DiscountPolicy {
    int discount(Member member, int price); // 할인 대상 금액 리턴
}
