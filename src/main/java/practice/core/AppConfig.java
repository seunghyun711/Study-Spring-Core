package practice.core;

import practice.core.discount.FixDiscountPolicy;
import practice.core.member.MemberService;
import practice.core.member.MemberServiceImpl;
import practice.core.member.MemoryMemberRepository;
import practice.core.order.OrderService;
import practice.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
