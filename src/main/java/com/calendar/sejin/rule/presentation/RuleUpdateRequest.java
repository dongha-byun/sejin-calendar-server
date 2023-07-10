package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleUpdateRequest {
    private String name;
    private String etc;

    @Builder
    public RuleUpdateRequest(String name, String etc) {
        this.name = name;
        this.etc = etc;
    }

    public RuleUpdateDto toDto() {
        return RuleUpdateDto.builder()
                .name(name)
                .etc(etc)
                .build();
    }
}
