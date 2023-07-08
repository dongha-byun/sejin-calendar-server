package com.calendar.sejin.model.domain;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class SizeInfo {
    private BigDecimal width = new BigDecimal("0.0");
    private BigDecimal height = new BigDecimal("0.0");
    private String inch;
    private int pages;
}
