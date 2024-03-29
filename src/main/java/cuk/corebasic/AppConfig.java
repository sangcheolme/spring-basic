package cuk.corebasic;

import cuk.corebasic.discount.DiscountPolicy;
import cuk.corebasic.discount.FixDiscountPolicy;
import cuk.corebasic.discount.RateDiscountPolicy;
import cuk.corebasic.member.MemberRepository;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemberServiceImpl;
import cuk.corebasic.member.MemoryMemberRepository;
import cuk.corebasic.order.OrderService;
import cuk.corebasic.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
