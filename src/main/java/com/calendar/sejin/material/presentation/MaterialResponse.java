package com.calendar.sejin.material.presentation;

import com.calendar.sejin.material.application.MaterialDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MaterialResponse {
    private Long id;
    private String type;
    private String standard1;
    private String standard2;
    private String content;
    private String color;

    @Builder
    public MaterialResponse(Long id, String type, String standard1, String standard2, String content, String color) {
        this.id = id;
        this.type = type;
        this.standard1 = standard1;
        this.standard2 = standard2;
        this.content = content;
        this.color = color;
    }

    public static MaterialResponse of(MaterialDto dto) {
        return MaterialResponse.builder()
                .id(dto.getId())
                .type(dto.getType().name())
                .standard1(dto.getStandard1())
                .standard2(dto.getStandard2())
                .content(dto.getContent())
                .color(dto.getColor())
                .build();
    }
}
