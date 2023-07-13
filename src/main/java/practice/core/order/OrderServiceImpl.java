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

    // 추상에 의존
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
