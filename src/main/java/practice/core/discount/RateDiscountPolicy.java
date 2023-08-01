package practice.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import practice.core.discount.annotation.MainDiscountPolicy;
import practice.core.member.Grade;
import practice.core.member.Member;

/**
 * <정률 할인 정책>
 * VIP인 고객의 주문 금액의 10% 할인 적용
 */
@Component
//@Primary // 조회할 빈이 2개 이상인 경우 해결방법 3 -  @Primary 사용
@MainDiscountPolicy
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
