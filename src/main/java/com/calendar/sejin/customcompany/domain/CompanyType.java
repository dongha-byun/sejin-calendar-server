package com.calendar.sejin.customcompany.domain;

import lombok.Getter;

@Getter
public enum CompanyType {
    MATERIAL("자재관련"),
    PRINTING("인쇄소"),
    PAPER("지업사"),
    BINDING("제본소"),
    AGENCY("총판");

    private final String typeName;

    CompanyType(String typeName) {
        this.typeName = typeName;
    }
}
