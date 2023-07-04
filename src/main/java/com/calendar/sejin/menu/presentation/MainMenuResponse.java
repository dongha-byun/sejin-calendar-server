package com.calendar.sejin.menu.presentation;

import com.calendar.sejin.menu.application.MainMenuQueryDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MainMenuResponse {
    private String id;
    private String name;
    private int order;
    private String path;
    private List<MainMenuResponse> childMenus;

    @Builder
    public MainMenuResponse(String id, String name, int order, String path, List<MainMenuResponse> childMenus) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.path = path;
        this.childMenus = childMenus;
    }

    public static MainMenuResponse of(MainMenuQueryDto dto) {
        List<MainMenuResponse> childMenus = new ArrayList<>();
        if(dto.getChildMenus() != null) {
            childMenus = dto.getChildMenus().stream()
                    .map(MainMenuResponse::of)
                    .toList();
        }

        return MainMenuResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .order(dto.getOrder())
                .path(dto.getPath())
                .childMenus(childMenus)
                .build();
    }
}
