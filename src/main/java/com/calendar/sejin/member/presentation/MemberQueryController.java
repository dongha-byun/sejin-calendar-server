package com.calendar.sejin.member.presentation;

import com.calendar.sejin.member.application.MemberDto;
import com.calendar.sejin.member.application.MemberQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberQueryController {
    private final MemberQueryService memberQueryService;

    @GetMapping("/api/v1/members")
    public ResponseEntity<List<MemberResponse>> findMemberAll() {
        List<MemberDto> allMembers = memberQueryService.findMemberAll();
        List<MemberResponse> memberResponses = allMembers.stream()
                .map(MemberResponse::of).toList();
        return ResponseEntity.ok().body(memberResponses);
    }
}
