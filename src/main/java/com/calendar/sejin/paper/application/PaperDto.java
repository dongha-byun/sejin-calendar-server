package com.calendar.sejin.paper.application;

import com.calendar.sejin.paper.domain.Paper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PaperDto {
    private Long id;
    private int weight;
    private String paperKind;
    private String standard;

    @Builder
    public PaperDto(Long id, int weight, String paperKind, String standard) {
        this.id = id;
        this.weight = weight;
        this.paperKind = paperKind;
        this.standard = standard;
    }

    public static PaperDto of(Paper entity) {
        return PaperDto.builder()
                .id(entity.getId())
                .weight(entity.getWeight())
                .paperKind(entity.getPaperKind())
                .standard(entity.getStandard())
                .build();
    }
}
