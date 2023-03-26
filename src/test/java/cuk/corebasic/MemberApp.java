package cuk.corebasic;

import cuk.corebasic.member.Grade;
import cuk.corebasic.member.Member;
import cuk.corebasic.member.MemberService;
import cuk.corebasic.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "userA", Grade.BASIC);

        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
