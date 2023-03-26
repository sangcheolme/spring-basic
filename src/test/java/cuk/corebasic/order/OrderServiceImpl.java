package cuk.corebasic.order;

import cuk.corebasic.discount.DiscountPolicy;
import cuk.corebasic.discount.FixDiscountPolicy;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberService memberService = new MemberServiceImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 조회
        Member member = memberService.findMember(memberId);
        //할인 적용
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }
}
