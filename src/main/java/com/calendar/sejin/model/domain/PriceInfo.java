package com.calendar.sejin.model.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class PriceInfo {

    @Column(name = "internal_price")
    private int internalPrice;

    @Embedded
    @AttributeOverride(name="price", column=@Column(name = "abroad_a1_price"))
    private Dollar abroadA1Price = new Dollar();

    @Embedded
    @AttributeOverride(name="price", column=@Column(name = "abroad_a2_price"))
    private Dollar abroadA2Price = new Dollar();

    @Embedded
    @AttributeOverride(name="price", column=@Column(name = "abroad_b_price"))
    private Dollar abroadBPrice = new Dollar();
}
