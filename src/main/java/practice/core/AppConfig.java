package practice.core;

import practice.core.discount.DiscountPolicy;
import practice.core.discount.FixDiscountPolicy;
import practice.core.discount.RateDiscountPolicy;
import practice.core.member.MemberRepository;
import practice.core.member.MemberService;
import practice.core.member.MemberServiceImpl;
import practice.core.member.MemoryMemberRepository;
import practice.core.order.OrderService;
import practice.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
