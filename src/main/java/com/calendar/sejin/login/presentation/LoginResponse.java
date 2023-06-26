package com.calendar.sejin.login.presentation;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginResponse {
    private Long id;
    private String loginId;
    private LocalDateTime loginDate;
}
