package com.calendar.sejin.member.domain;

import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class JPAMemberQueryRepository implements MemberQueryRepository{

    private final EntityManager em;

    @Override
    public List<Member> findAllMember() {
        return em.createQuery(
                "select m from Member m", Member.class
        ).getResultList();
    }
}
