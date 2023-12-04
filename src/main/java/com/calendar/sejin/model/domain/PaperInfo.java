package com.calendar.sejin.model.domain;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Embeddable
public class PaperInfo {
    private int weight;
    private String type;
    private String standard;
    private BigDecimal usagePerOne = new BigDecimal("0.00");
}
