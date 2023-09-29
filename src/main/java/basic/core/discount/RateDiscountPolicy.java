package basic.core.discount;

import basic.core.member.Grade;
import basic.core.member.Member;

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
