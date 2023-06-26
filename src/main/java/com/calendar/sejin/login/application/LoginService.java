package com.calendar.sejin.login.application;

import com.calendar.sejin.login.domain.LoginRepository;
import com.calendar.sejin.member.application.MemberDto;
import com.calendar.sejin.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public MemberDto login(String loginId, String password) {
        Member findMember = loginRepository.findByLoginId(loginId)
                .filter(member -> member.getPassword().equals(password))
                .orElseThrow(
                        () -> new IllegalArgumentException("로그인 정보를 다시 확인해주세요.")
                );

        return MemberDto.of(findMember);
    }
}
