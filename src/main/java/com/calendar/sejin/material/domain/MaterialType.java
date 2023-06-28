package com.calendar.sejin.material.domain;

import lombok.Getter;

@Getter
public enum MaterialType {
    GOLD("금구"),
    HOLDER("홀더"),
    ACETATE("아스테지"),
    TWIN("TWIN"),
    BIG_PARER("대지"),
    BOX("Box"),
    SACK("봉투"),
    HALF_MOON("반달고리"),
    VINYL("비닐");

    private final String typeName;

    MaterialType(String typeName) {
        this.typeName = typeName;
    }
}
