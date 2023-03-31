package cuk.corebasic.discount;

import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() throws Exception {
        //given
        Member member = new Member(1L, "userA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(2000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() throws Exception {
        //given
        Member member = new Member(1L, "userA", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 20000);

        //then
        assertThat(discount).isEqualTo(0);
    }

    

}