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
public class PriceInfo {
    private int internalPrice;

    @ColumnDefault(value = "0.00")
    private BigDecimal abroadA1Price;

    @ColumnDefault(value = "0.00")
    private BigDecimal abroadA2Price;

    @ColumnDefault(value = "0.00")
    private BigDecimal abroadBPrice;
}
