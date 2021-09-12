package com.spring.hello.core.order;

import com.spring.hello.core.AppConfig;
import com.spring.hello.core.member.Grade;
import com.spring.hello.core.member.Member;
import com.spring.hello.core.member.MemberService;
import com.spring.hello.core.member.MemberServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderserviceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        //        MemberService memberService = new MemberServiceImpl();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void fieldInjectionTest() {
        //필드에 의존성을 주입하게 되면 해당 객체에서 null point exception이 날 것이다.
        // setter를 통해서 생성해야 하는데 이전에 사용하기에 exception이 발생

//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L, "itemA", 10000);
    }
}
