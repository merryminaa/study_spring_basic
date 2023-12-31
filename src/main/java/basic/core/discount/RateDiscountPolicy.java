package basic.core.discount;

import basic.core.annotation.MainDiscountPolicy;
import basic.core.member.Grade;
import basic.core.member.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy //직접등록한 어노테이션
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountRate = 10; //정률 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountRate / 100;
        } else {
            return 0;
        }
    }
}
