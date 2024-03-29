package cuk.corebasic;

import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemberServiceImpl;
import cuk.corebasic.order.Order;
import cuk.corebasic.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "userA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
