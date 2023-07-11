package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.Rule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleDto {
    private Long id;
    private String alias;
    private String name;
    private String etc;

    @Builder
    public RuleDto(Long id, String alias, String name, String etc) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.etc = etc;
    }

    public static RuleDto of(Rule entity) {
        return RuleDto.builder()
                .id(entity.getId())
                .alias(entity.getAlias())
                .name(entity.getName())
                .etc(entity.getEtc())
                .build();
    }
}
