package com.spring.hello.core.discount;

import com.spring.hello.core.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
