package com.calendar.sejin.model.domain;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PaperInfo {
    private int weight;
    private String type;
    private String standard;

    @ColumnDefault(value = "0.0")
    private BigDecimal usagePerOne;
}
