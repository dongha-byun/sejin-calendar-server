package com.calendar.sejin.paper.presentation;

import com.calendar.sejin.paper.application.PaperCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaperCreateRequest {
    private int weight;
    private String paperKind;
    private String standard;

    public PaperCreateDto toCreateDto() {
        return PaperCreateDto.builder()
                .weight(weight)
                .paperKind(paperKind)
                .standard(standard)
                .build();
    }
}
