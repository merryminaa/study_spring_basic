package basic.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import basic.core.member.Grade;
import basic.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void discountForVIP() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌 경우 할인이 적용되지 않아야 한다.")
    void discountForNoVIP() {
        //given
        Member member = new Member(2L, "memberVIP", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}