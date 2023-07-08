package com.calendar.sejin.model.application;

import com.calendar.sejin.model.domain.BindingInfo;
import com.calendar.sejin.model.domain.BoxInfo;
import com.calendar.sejin.model.domain.BrandPrintingInfo;
import com.calendar.sejin.model.domain.Dollar;
import com.calendar.sejin.model.domain.Model;
import com.calendar.sejin.model.domain.PaperInfo;
import com.calendar.sejin.model.domain.PriceInfo;
import com.calendar.sejin.model.domain.PrintingInfo;
import com.calendar.sejin.model.domain.SizeInfo;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ModelCreateDto {
    private String num;
    private String name;
    private BigDecimal width;
    private BigDecimal height;
    private String inch;
    private int pages;
    private int internalPrice;
    private BigDecimal abroadA1Price;
    private BigDecimal abroadA2Price;
    private BigDecimal abroadBPrice;
    private int coverPaperWidth;
    private String coverPaperType;
    private String coverPaperStandard;
    private BigDecimal coverPaperUsagePerOne;
    private int innerPaperWidth;
    private String innerPaperType;
    private String innerPaperStandard;
    private BigDecimal innerPaperUsagePerOne;
    private String bindingMethod;
    private int bindingPrice;
    private int coverSobu;
    private int coverDosu;
    private int innerSobu;
    private int innerDosu;
    private String brandPrintingMethod;
    private int brandPrintingSizeCm;
    private String brandPrintingSizeInch;
    private String boxType;
    private int countPerOneBox;

    @Builder
    public ModelCreateDto(String num, String name, BigDecimal width, BigDecimal height, String inch, int pages,
                          int internalPrice, BigDecimal abroadA1Price, BigDecimal abroadA2Price,
                          BigDecimal abroadBPrice,
                          int coverPaperWidth, String coverPaperType, String coverPaperStandard,
                          BigDecimal coverPaperUsagePerOne, int innerPaperWidth, String innerPaperType,
                          String innerPaperStandard, BigDecimal innerPaperUsagePerOne, String bindingMethod,
                          int bindingPrice, int coverSobu, int coverDosu, int innerSobu, int innerDosu,
                          String brandPrintingMethod, int brandPrintingSizeCm, String brandPrintingSizeInch,
                          String boxType,
                          int countPerOneBox) {
        this.num = num;
        this.name = name;
        this.width = width;
        this.height = height;
        this.inch = inch;
        this.pages = pages;
        this.internalPrice = internalPrice;
        this.abroadA1Price = abroadA1Price;
        this.abroadA2Price = abroadA2Price;
        this.abroadBPrice = abroadBPrice;
        this.coverPaperWidth = coverPaperWidth;
        this.coverPaperType = coverPaperType;
        this.coverPaperStandard = coverPaperStandard;
        this.coverPaperUsagePerOne = coverPaperUsagePerOne;
        this.innerPaperWidth = innerPaperWidth;
        this.innerPaperType = innerPaperType;
        this.innerPaperStandard = innerPaperStandard;
        this.innerPaperUsagePerOne = innerPaperUsagePerOne;
        this.bindingMethod = bindingMethod;
        this.bindingPrice = bindingPrice;
        this.coverSobu = coverSobu;
        this.coverDosu = coverDosu;
        this.innerSobu = innerSobu;
        this.innerDosu = innerDosu;
        this.brandPrintingMethod = brandPrintingMethod;
        this.brandPrintingSizeCm = brandPrintingSizeCm;
        this.brandPrintingSizeInch = brandPrintingSizeInch;
        this.boxType = boxType;
        this.countPerOneBox = countPerOneBox;
    }

    public Model toEntity() {
        return Model.builder()
                .num(num)
                .name(name)
                .sizeInfo(new SizeInfo(width, height, inch, pages))
                .priceInfo(
                        new PriceInfo(
                                internalPrice,
                                new Dollar(abroadA1Price),
                                new Dollar(abroadA2Price),
                                new Dollar(abroadBPrice)
                        )
                )
                .coverPaperInfo(new PaperInfo(coverPaperWidth, coverPaperType, coverPaperStandard, coverPaperUsagePerOne))
                .innerPaperInfo(new PaperInfo(innerPaperWidth, innerPaperType, innerPaperStandard, innerPaperUsagePerOne))
                .bindingInfo(new BindingInfo(bindingMethod, bindingPrice))
                .coverPrintingInfo(new PrintingInfo(coverSobu, coverDosu))
                .innerPrintingInfo(new PrintingInfo(innerSobu, innerDosu))
                .brandPrintingInfo(new BrandPrintingInfo(brandPrintingMethod, brandPrintingSizeCm, brandPrintingSizeInch))
                .boxInfo(new BoxInfo(boxType, countPerOneBox))
                .build();
    }
}
