package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleCreateDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleCreateRequest {
    @NotBlank(message = "룰ID 는 필수항목입니다.")
    private String alias;
    @NotBlank(message = "룰이름 은 필수항목입니다.")
    private String name;
    private String etc;

    @Builder
    public RuleCreateRequest(String alias, String name, String etc) {
        this.alias = alias;
        this.name = name;
        this.etc = etc;
    }

    public RuleCreateDto toCreateDto() {
        return RuleCreateDto.builder()
                .alias(alias)
                .name(name)
                .etc(etc)
                .build();
    }
}
