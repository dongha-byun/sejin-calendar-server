package com.calendar.sejin.material.application;

import com.calendar.sejin.material.domain.Material;
import com.calendar.sejin.material.domain.MaterialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MaterialUpdateDto {
    private MaterialType type;
    private String standard1;
    private String standard2;
    private String content;
    private String color;

    @Builder
    public MaterialUpdateDto(MaterialType type, String standard1, String standard2, String content, String color) {
        this.type = type;
        this.standard1 = standard1;
        this.standard2 = standard2;
        this.content = content;
        this.color = color;
    }

    public Material toEntity() {
        return Material.builder()
                .type(type)
                .standard1(standard1)
                .standard2(standard2)
                .content(content)
                .color(color)
                .build();
    }
}
