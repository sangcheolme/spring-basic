package cuk.corebasic.order;

import cuk.corebasic.AppConfig;
import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() throws Exception {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        
        //when
        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        //then
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(2000);
    }
    

}