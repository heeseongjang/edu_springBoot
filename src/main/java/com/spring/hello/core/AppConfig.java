package com.spring.hello.core;

import com.spring.hello.core.discount.DiscountPolicy;
import com.spring.hello.core.discount.FixDiscountPolicy;
import com.spring.hello.core.discount.RateDiscountPolicy;
import com.spring.hello.core.member.MemberRepository;
import com.spring.hello.core.member.MemberService;
import com.spring.hello.core.member.MemberServiceImpl;
import com.spring.hello.core.member.MemoryMemberRepository;
import com.spring.hello.core.order.OrderService;
import com.spring.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        System.out.println("AppConfig.discountPolicy");
        return new FixDiscountPolicy();
    }
}
