package com.calendar.sejin.paper.presentation;

import com.calendar.sejin.paper.application.PaperDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaperResponse {
    private Long id;
    private int weight;
    private String paperKind;
    private String standard;

    @Builder
    public PaperResponse(Long id, int weight, String paperKind, String standard) {
        this.id = id;
        this.weight = weight;
        this.paperKind = paperKind;
        this.standard = standard;
    }

    public static PaperResponse of(PaperDto dto) {
        return PaperResponse.builder()
                .id(dto.getId())
                .weight(dto.getWeight())
                .paperKind(dto.getPaperKind())
                .standard(dto.getStandard())
                .build();
    }
}
