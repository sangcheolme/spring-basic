package cuk.corebasic.autowired;

import cuk.corebasic.AutoAppConfig;
import cuk.corebasic.discount.DiscountPolicy;
import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {

    @Test
    void findAllBean() {
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discount = discountService.discount(member, 20000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discount).isEqualTo(1000);

    }

    static class DiscountService {

        private Map<String, DiscountPolicy> policyMap;
        private List<DiscountPolicy> policies;

        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            System.out.println("discountPolicy = " + discountPolicy);
            System.out.println("discountCode = " + discountCode);

            return discountPolicy.discount(member, price);
        }
    }

}
