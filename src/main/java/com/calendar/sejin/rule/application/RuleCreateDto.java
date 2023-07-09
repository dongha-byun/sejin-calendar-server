package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.Rule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleCreateDto {
    private String ruleId;
    private String name;
    private String etc;

    @Builder
    public RuleCreateDto(String ruleId, String name, String etc) {
        this.ruleId = ruleId;
        this.name = name;
        this.etc = etc;
    }

    public Rule toEntity() {
        return Rule.builder()
                .ruleId(ruleId)
                .name(name)
                .etc(etc)
                .build();
    }
}
