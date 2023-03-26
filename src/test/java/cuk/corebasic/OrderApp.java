package cuk.corebasic;

import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemberServiceImpl;
import cuk.corebasic.order.Order;
import cuk.corebasic.order.OrderService;
import cuk.corebasic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("itemA = " + itemA);
    }
}
