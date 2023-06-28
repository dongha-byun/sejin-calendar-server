package com.calendar.sejin.material.presentation;

import com.calendar.sejin.material.application.MaterialCreateDto;
import com.calendar.sejin.material.application.MaterialUpdateDto;
import com.calendar.sejin.material.domain.MaterialType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MaterialUpdateRequest {
    private String type;
    private String standard1;
    private String standard2;
    private String content;
    private String color;

    public MaterialUpdateDto toUpdateDto() {
        return MaterialUpdateDto.builder()
                .type(MaterialType.valueOf(type))
                .standard1(standard1)
                .standard2(standard2)
                .content(content)
                .color(color)
                .build();
    }
}
