package practice.core.discount;

import practice.core.member.Grade;
import practice.core.member.Member;

/**
 * <정률 할인 정책>
 * VIP인 고객의 주문 금액의 10% 할인 적용
 */
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10; // 10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }else {
            return 0;
        }
    }
}
