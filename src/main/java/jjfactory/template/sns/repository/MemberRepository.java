package jjfactory.template.sns.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.template.sns.entity.Member;
import jjfactory.template.sns.entity.QMember;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.template.sns.entity.QMember.member;

@RequiredArgsConstructor
@Repository
public class MemberRepository {

    private final JPAQueryFactory queryFactory;

    public Member findById(Long id){
        Member member = queryFactory.selectFrom(QMember.member)
                .where(QMember.member.id.eq(id))
                .fetchOne();
        return member;
    }

    public Member findByName(String name){
        Member member = queryFactory.selectFrom(QMember.member)
                .where(QMember.member.name.eq(name))
                .fetchOne();
        return member;
    }

    public List<Member> findAll(){
        List<Member> MemberList = queryFactory.selectFrom(member)
                .fetch();

        return MemberList;
    }

}
