package com.calendar.sejin.command.printing.domain;

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
public class PaperInfo {
    private int weight;
    private String type;
    private String standard;
    private BigDecimal capacity = new BigDecimal("0.00");
}
