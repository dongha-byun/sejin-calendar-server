package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.Rule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleCreateDto {
    private String alias;
    private String name;
    private String etc;

    @Builder
    public RuleCreateDto(String alias, String name, String etc) {
        this.alias = alias;
        this.name = name;
        this.etc = etc;
    }

    public Rule toEntity() {
        return Rule.builder()
                .alias(alias)
                .name(name)
                .etc(etc)
                .build();
    }
}
