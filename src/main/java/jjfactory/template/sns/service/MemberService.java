package jjfactory.template.sns.service;

import jjfactory.template.sns.entity.Member;
import jjfactory.template.sns.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional(readOnly = true)
    public Member getMember(Long id){
        return memberRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Member> getAllMember(){
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member getByName(String name){
        return memberRepository.findByName(name);
    }
}
