package practice.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.core.discount.DiscountPolicy;
import practice.core.discount.FixDiscountPolicy;
import practice.core.discount.RateDiscountPolicy;
import practice.core.member.MemberRepository;
import practice.core.member.MemberService;
import practice.core.member.MemberServiceImpl;
import practice.core.member.MemoryMemberRepository;
import practice.core.order.OrderService;
import practice.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
