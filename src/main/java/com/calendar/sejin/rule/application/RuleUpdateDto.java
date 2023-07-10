package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.Rule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleUpdateDto {
    private String name;
    private String etc;

    @Builder
    public RuleUpdateDto(String name, String etc) {
        this.name = name;
        this.etc = etc;
    }

    public Rule toEntity() {
        return Rule.builder()
                .name(name)
                .etc(etc)
                .build();
    }
}
