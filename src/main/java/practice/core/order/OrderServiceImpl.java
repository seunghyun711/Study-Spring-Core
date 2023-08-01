package practice.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import practice.core.discount.DiscountPolicy;
import practice.core.discount.FixDiscountPolicy;
import practice.core.member.Member;
import practice.core.member.MemberRepository;
import practice.core.member.MemoryMemberRepository;

/**
 * <주문 서비스 구현 클래스>
 */
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    // 추상에 의존
    private final MemberRepository memberRepository;
    // 조회할 빈이 2개 이상인 경우 해결방법 1 -  @Autowired 필드명 매칭
    @Autowired
    private final DiscountPolicy rateDiscountPolicy;

    // 의존관계 주입 방식1 - 생성자 주입
//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    // 의존관계 주입 방식2 - 수정자 주입
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    // 의존관계 주입 방식3 - 필드 주입
//    @Autowired private MemberRepository memberRepository;
//    @Autowired private DiscountPolicy discountPolicy;

    // 의존관계 주입 방식4 - 일반 메서드 주입
//    @Autowired
//    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    // 테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = rateDiscountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
