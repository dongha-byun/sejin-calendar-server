package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.RuleMenu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleMenuDto {
    private Long id;
    private String menuId;
    private String menuName;

    @Builder
    public RuleMenuDto(Long id, String menuId, String menuName) {
        this.id = id;
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public static RuleMenuDto of(RuleMenu ruleMenu) {
        return RuleMenuDto.builder()
                .id(ruleMenu.getId())
                .menuId(ruleMenu.getMenuId())
                .menuName(ruleMenu.getMenuName())
                .build();
    }
}
