package cuk.corebasic.order;

import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() throws Exception {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        
        //when
        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        //then
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);
    }
    

}