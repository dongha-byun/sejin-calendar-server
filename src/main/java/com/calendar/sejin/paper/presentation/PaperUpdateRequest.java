package com.calendar.sejin.paper.presentation;

import com.calendar.sejin.paper.application.PaperUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaperUpdateRequest {
    private int weight;
    private String paperKind;
    private String standard;

    public PaperUpdateDto toUpdateDto() {
        return PaperUpdateDto.builder()
                .weight(weight)
                .paperKind(paperKind)
                .standard(standard)
                .build();
    }
}
