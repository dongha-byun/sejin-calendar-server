package com.calendar.sejin.rule.application;

import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RuleMenuInsertDto {
    private String menuId;
    private List<RuleMenuInsertDto> subMenus;

    @Builder
    public RuleMenuInsertDto(String menuId, List<RuleMenuInsertDto> subMenus) {
        this.menuId = menuId;
        this.subMenus = subMenus;
    }

    public List<String> getAllMenuIds() {
        if(subMenus == null || subMenus.size() == 0) {
            return List.of(menuId);
        }

        List<String> menuIds = new ArrayList<>();
        menuIds.add(menuId);
        for (RuleMenuInsertDto subMenu : subMenus) {
            menuIds.addAll(subMenu.getAllMenuIds());
        }
        return menuIds;
    }

}
