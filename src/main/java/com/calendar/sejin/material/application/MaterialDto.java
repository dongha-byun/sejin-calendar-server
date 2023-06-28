package com.calendar.sejin.material.application;

import com.calendar.sejin.material.domain.Material;
import com.calendar.sejin.material.domain.MaterialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MaterialDto {
    private Long id;
    private MaterialType type;
    private String standard1;
    private String standard2;
    private String content;
    private String color;

    @Builder
    public MaterialDto(Long id, MaterialType type, String standard1, String standard2, String content, String color) {
        this.id = id;
        this.type = type;
        this.standard1 = standard1;
        this.standard2 = standard2;
        this.content = content;
        this.color = color;
    }

    public static MaterialDto of(Material entity) {
        return MaterialDto.builder()
                .id(entity.getId())
                .type(entity.getType())
                .standard1(entity.getStandard1())
                .standard2(entity.getStandard2())
                .content(entity.getContent())
                .color(entity.getColor())
                .build();
    }
}
