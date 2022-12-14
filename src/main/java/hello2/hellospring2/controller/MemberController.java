package hello2.hellospring2.controller;

import hello2.hellospring2.domain.Member;
import hello2.hellospring2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {


    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members/new")
    public String createForm(){
        return "members/creatMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/"; //회원가입이 끝나면 홈 화면으로 보내기 ?

    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //멤버를 다 끄집어 온다
        model.addAttribute("members", members); // 모델에다가 담아서 화면에 넘긴다
        return "members/memberList";
    }
}
