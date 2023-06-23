package com.calendar.sejin.member.presentation;

import com.calendar.sejin.member.application.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberResponse {
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String telNo;
    private String email;
    private String etc;

    public static MemberResponse of(MemberDto dto) {
        return new MemberResponse(
                dto.getId(), dto.getLoginId(), dto.getPassword(), dto.getName(),
                dto.getAddress(), dto.getTelNo(), dto.getEmail(), dto.getEtc()
        );
    }
}
