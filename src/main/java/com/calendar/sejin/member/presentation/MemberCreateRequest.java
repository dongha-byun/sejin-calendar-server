package com.calendar.sejin.member.presentation;

import com.calendar.sejin.member.application.MemberCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberCreateRequest {

    @NotBlank(message = "로그인아이디는 필수항목 입니다.")
    private String loginId;
    @NotBlank(message = "비밀번호는 필수항목 입니다.")
    private String password;
    @NotBlank(message = "이름은 필수항목 입니다.")
    private String name;
    private String address;
    private String telNo;
    private String email;
    private String etc;

    @Builder
    public MemberCreateRequest(String loginId, String password, String name, String address, String telNo, String email,
                               String etc) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.address = address;
        this.telNo = telNo;
        this.email = email;
        this.etc = etc;
    }

    public static MemberCreateDto toDto(MemberCreateRequest request) {
        return new MemberCreateDto(
                request.getLoginId(), request.getPassword(), request.getName(),
                request.getAddress(), request.getTelNo(), request.getEmail(), request.getEtc()
        );
    }
}
