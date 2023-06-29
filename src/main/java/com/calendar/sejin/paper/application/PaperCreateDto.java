package com.calendar.sejin.paper.application;

import com.calendar.sejin.paper.domain.Paper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaperCreateDto {
    private int weight;
    private String paperKind;
    private String standard;

    @Builder
    public PaperCreateDto(int weight, String paperKind, String standard) {
        this.weight = weight;
        this.paperKind = paperKind;
        this.standard = standard;
    }

    public Paper toEntity() {
        return Paper.builder()
                .weight(weight)
                .paperKind(paperKind)
                .standard(standard)
                .build();
    }
}
