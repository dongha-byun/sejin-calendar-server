package com.calendar.sejin.member.application;

import com.calendar.sejin.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberDto {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String telNo;
    private String email;
    private String etc;

    public static MemberDto of(Member member) {
        return new MemberDto(
                member.getId(), member.getLoginId(), member.getPassword(), member.getName(),
                member.getAddress(), member.getTelNo(), member.getEmail(), member.getEtc()
        );
    }
}
