package com.calendar.sejin.member.application;

import com.calendar.sejin.member.domain.Member;
import com.calendar.sejin.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberDto createMember(MemberCreateDto dto) {
        Member member = dto.toEntity();
        Member savedMember = memberRepository.save(member);

        return MemberDto.of(savedMember);
    }

    public MemberDto findMember(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new IllegalArgumentException("회원 정보 조회 실패")
                );
        return MemberDto.of(findMember);
    }

    public void deleteMember(Long memberId) {
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(
                        () -> new IllegalArgumentException("회원 정보 조회 실패")
                );
        memberRepository.delete(findMember);
    }
}
