package basic.core.order;


import basic.core.discount.FixDiscountPolicy;
import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        org.assertj.core.api.Assertions.assertThat(order.getDiscountPrice()).isEqualTo(10000);
    }

}