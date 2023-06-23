package com.calendar.sejin.member.application;

import com.calendar.sejin.member.domain.Member;
import com.calendar.sejin.member.domain.MemberQueryRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberQueryService {
    private final MemberQueryRepository memberQueryRepository;

    public List<MemberDto> findMemberAll() {
        List<Member> allMembers = memberQueryRepository.findAllMember();
        return allMembers.stream()
                .map(MemberDto::of)
                .collect(Collectors.toList());
    }

}
