package com.calendar.sejin.member.presentation;

import com.calendar.sejin.api.ApiResult;
import com.calendar.sejin.member.application.MemberCreateDto;
import com.calendar.sejin.member.application.MemberDto;
import com.calendar.sejin.member.application.MemberService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/v1/members")
    public ApiResult<MemberResponse> findMember(@Valid @RequestBody MemberCreateRequest request) {
        MemberCreateDto memberCreateDto = MemberCreateRequest.toDto(request);
        MemberDto createdMember = memberService.createMember(memberCreateDto);
        MemberResponse response = MemberResponse.of(createdMember);

        return ApiResult.created("사용자가 성공적으로 등록되었습니다.", response);
    }

    @GetMapping("/api/v1/members/{id}")
    public ApiResult<MemberResponse> findMember(@PathVariable("id") Long id) {
        MemberDto memberDto = memberService.findMember(id);
        MemberResponse response = MemberResponse.of(memberDto);

        return ApiResult.ok("사용자를 성공적으로 조회했습니다.", response);
    }

    @DeleteMapping("/api/v1/members/{id}")
    public ApiResult<MemberResponse> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMember(id);

        return ApiResult.noContent("삭제가 완료되었습니다.");
    }
}
