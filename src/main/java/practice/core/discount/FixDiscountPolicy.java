package practice.core.discount;

import practice.core.member.Grade;
import practice.core.member.Member;

/**
 * <정액 할인 정책>
 * 회원등급이 VIP인 회원에 대해 1000원 할인
 */
public class FixDiscountPolicy implements DiscountPolicy{
    private final int discountFixAmount = 1000; // 할인 금액 : 1000원
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount; // 회원 등급이 VIP면 1000원 할인 적용
        }else{
            return 0;
        }
    }
}
