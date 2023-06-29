package com.calendar.sejin.paper.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "papers")
@Entity
public class Paper {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weight;
    private String paperKind;
    private String standard;

    @Builder
    public Paper(int weight, String paperKind, String standard) {
        this.weight = weight;
        this.paperKind = paperKind;
        this.standard = standard;
    }

    public void update(Paper updateInfo) {
        this.weight = updateInfo.getWeight();
        this.paperKind = updateInfo.getPaperKind();
        this.standard = updateInfo.getStandard();
    }
}
