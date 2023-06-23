package com.calendar.sejin.member.domain;

import java.util.List;

public interface MemberQueryRepository {
    List<Member> findAllMember();
}
