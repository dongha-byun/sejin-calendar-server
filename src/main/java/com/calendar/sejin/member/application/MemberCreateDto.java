package com.calendar.sejin.member.application;

import com.calendar.sejin.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberCreateDto {
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String telNo;
    private String email;
    private String etc;

    public Member toEntity() {
        return Member.builder()
                .loginId(loginId)
                .password(password)
                .name(name)
                .address(address)
                .telNo(telNo)
                .email(email)
                .etc(etc)
                .build();
    }
}
