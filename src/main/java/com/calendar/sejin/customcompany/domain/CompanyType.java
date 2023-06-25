package com.calendar.sejin.customcompany.domain;

public enum CompanyType {
    MATERIAL("자재관련"),
    PRINT("인쇄소"),
    PAPER("지업사"),
    BINDING("제본소"),
    AGENCY("총판");

    private String typeName;

    CompanyType(String typeName) {
        this.typeName = typeName;
    }
}
