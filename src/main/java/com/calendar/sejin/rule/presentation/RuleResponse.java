package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleResponse {
    private Long id;
    private String ruleId;
    private String name;
    private String etc;

    @Builder
    public RuleResponse(Long id, String ruleId, String name, String etc) {
        this.id = id;
        this.ruleId = ruleId;
        this.name = name;
        this.etc = etc;
    }

    public static RuleResponse of(RuleDto dto) {
        return RuleResponse.builder()
                .id(dto.getId())
                .ruleId(dto.getRuleId())
                .name(dto.getName())
                .etc(dto.getEtc())
                .build();
    }
}
