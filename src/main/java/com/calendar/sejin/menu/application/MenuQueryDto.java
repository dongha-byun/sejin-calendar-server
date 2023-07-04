package com.calendar.sejin.menu.application;

import com.calendar.sejin.menu.domain.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MenuQueryDto {
    private String id;
    private String name;
    private int order;
    private String path;

    @Builder
    public MenuQueryDto(String id, String name, String path, int order) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.order = order;
    }

    public static MenuQueryDto of(Menu menu) {
        return MenuQueryDto.builder()
                .id(menu.getId())
                .name(menu.getName())
                .order(menu.getOrder())
                .path(menu.getPath())
                .build();
    }
}
