package com.calendar.sejin.menu.application;

import com.calendar.sejin.menu.domain.Menu;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MainMenuQueryDto {
    private String id;
    private String name;
    private int order;
    private String path;
    private List<MainMenuQueryDto> childMenus;

    @Builder
    public MainMenuQueryDto(String id, String name, int order, String path, List<MainMenuQueryDto> childMenus) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.path = path;
        this.childMenus = childMenus;
    }

    public static MainMenuQueryDto of(Menu menu) {
        List<MainMenuQueryDto> childMenus = menu.getChildMenus().stream()
                .map(MainMenuQueryDto::of)
                .toList();
        return MainMenuQueryDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .order(menu.getOrder())
                .path(menu.getPath())
                .childMenus(childMenus)
                .build();
    }
}
