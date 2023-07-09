package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleCreateDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleCreateRequest {
    private String ruleId;
    private String name;
    private String etc;

    @Builder
    public RuleCreateRequest(String ruleId, String name, String etc) {
        this.ruleId = ruleId;
        this.name = name;
        this.etc = etc;
    }

    public RuleCreateDto toCreateDto() {
        return RuleCreateDto.builder()
                .ruleId(ruleId)
                .name(name)
                .etc(etc)
                .build();
    }
}
