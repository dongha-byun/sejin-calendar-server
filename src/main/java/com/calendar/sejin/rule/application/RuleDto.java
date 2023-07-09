package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.Rule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleDto {
    private Long id;
    private String ruleId;
    private String name;
    private String etc;

    @Builder
    public RuleDto(Long id, String ruleId, String name, String etc) {
        this.id = id;
        this.ruleId = ruleId;
        this.name = name;
        this.etc = etc;
    }

    public static RuleDto of(Rule entity) {
        return RuleDto.builder()
                .id(entity.getId())
                .ruleId(entity.getRuleId())
                .name(entity.getName())
                .etc(entity.getEtc())
                .build();
    }
}
