package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleResponse {
    private Long id;
    private String alias;
    private String name;
    private String etc;

    @Builder
    public RuleResponse(Long id, String alias, String name, String etc) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.etc = etc;
    }

    public static RuleResponse of(RuleDto dto) {
        return RuleResponse.builder()
                .id(dto.getId())
                .alias(dto.getAlias())
                .name(dto.getName())
                .etc(dto.getEtc())
                .build();
    }
}
