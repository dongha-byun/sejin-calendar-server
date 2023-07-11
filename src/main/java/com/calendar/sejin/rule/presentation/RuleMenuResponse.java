package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleMenuDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleMenuResponse {
    private Long id;
    private String menuId;
    private String menuName;

    @Builder
    public RuleMenuResponse(Long id, String menuId, String menuName) {
        this.id = id;
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public static RuleMenuResponse of(RuleMenuDto dto) {
        return RuleMenuResponse.builder()
                .id(dto.getId())
                .menuId(dto.getMenuId())
                .menuName(dto.getMenuName())
                .build();
    }
}
