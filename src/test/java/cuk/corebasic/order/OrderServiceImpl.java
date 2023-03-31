package cuk.corebasic.order;

import cuk.corebasic.discount.DiscountPolicy;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberRepository;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 조회
        Member member = memberRepository.findById(memberId);
        //할인 적용
        int discount = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discount);
    }
}
