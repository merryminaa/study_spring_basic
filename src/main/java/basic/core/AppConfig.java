package basic.core;

import basic.core.discount.DiscountPolicy;
import basic.core.discount.FixDiscountPolicy;
import basic.core.discount.RateDiscountPolicy;
import basic.core.member.MemberService;
import basic.core.member.MemberServiceImpl;
import basic.core.member.MemoryMemberRepository;
import basic.core.order.OrderService;
import basic.core.order.OrderServiceImpl;

//애플리케이션 동작에 필요한 구현체 생성
public class AppConfig {

    //생성자 주입방식
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository(); //역할과 구현 클래스 분리
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
