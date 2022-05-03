package jjfactory.template.sns.api;

import jjfactory.template.crud.dto.ApiRes;
import jjfactory.template.sns.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberApi {
    private final MemberService memberService;

    @GetMapping("/members")
    public ApiRes<?> findAll(){
        return new ApiRes<>(memberService.getAllMember());
    }

    @GetMapping("/members/{id}")
    public ApiRes<?> findMember(@PathVariable Long id){
        return new ApiRes<>(memberService.getMember(id));
    }

    @GetMapping("/members/search")
    public ApiRes<?> findMember(@RequestParam String name){
        return new ApiRes<>(memberService.getByName(name));
    }
}

