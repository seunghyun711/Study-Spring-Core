package practice.core.order;

import practice.core.discount.DiscountPolicy;
import practice.core.discount.FixDiscountPolicy;
import practice.core.member.Member;
import practice.core.member.MemberRepository;
import practice.core.member.MemoryMemberRepository;

/**
 * <주문 서비스 구현 클래스>
 */
public class OrderServiceImpl implements OrderService{

    //회원 저장소와 할인 정책을 의존할 때 각 인터페이스의 구현 클래스에 의존한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
