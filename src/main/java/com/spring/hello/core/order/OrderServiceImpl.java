package com.spring.hello.core.order;

import com.spring.hello.core.annotation.MainDisCountPolicy;
import com.spring.hello.core.discount.DiscountPolicy;
import com.spring.hello.core.discount.FixDiscountPolicy;
import com.spring.hello.core.discount.RateDiscountPolicy;
import com.spring.hello.core.member.Member;
import com.spring.hello.core.member.MemberRepository;
import com.spring.hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    @Autowired
    //생성자가 하나일 경우 @Autowired를 사용 없이 자동 의존성 주입이 된다.
    //@RequiredArgsConstructor로 인해서 삭제 가능 @RequiredArgsConstructor가 아래 생성자 역할을 한다.
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    public OrderServiceImpl(MemberRepository memberRepository, @MainDisCountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
