package com.calendar.sejin.login.presentation;

import com.calendar.sejin.login.application.LoginService;
import com.calendar.sejin.member.application.MemberDto;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/api/v1/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        MemberDto memberDto = loginService.login(loginRequest.getLoginId(), loginRequest.getPassword());
        LoginResponse response = new LoginResponse(memberDto.getId(), memberDto.getLoginId(), LocalDateTime.now());

        return ResponseEntity.ok().body(response);
    }
}
