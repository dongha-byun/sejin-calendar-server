package com.calendar.sejin.model.presentation;

import com.calendar.sejin.model.application.ModelDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ModelResponse {
    private Long id;
    private String num;
    private String name;
    private String width;
    private String height;
    private String inch;
    private int pages;
    private int internalPrice;
    private String abroadA1Price;
    private String abroadA2Price;
    private String abroadBPrice;
    private int coverPaperWidth;
    private String coverPaperType;
    private String coverPaperStandard;
    private String coverPaperUsagePerOne;
    private int innerPaperWidth;
    private String innerPaperType;
    private String innerPaperStandard;
    private String innerPaperUsagePerOne;
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
    public ModelResponse(Long id, String num, String name, String width, String height, String inch, int pages,
                         int internalPrice, String abroadA1Price, String abroadA2Price, String abroadBPrice,
                         int coverPaperWidth, String coverPaperType, String coverPaperStandard,
                         String coverPaperUsagePerOne, int innerPaperWidth, String innerPaperType,
                         String innerPaperStandard, String innerPaperUsagePerOne, String bindingMethod,
                         int bindingPrice, int coverSobu, int coverDosu, int innerSobu, int innerDosu,
                         String brandPrintingMethod, int brandPrintingSizeCm, String brandPrintingSizeInch,
                         String boxType,
                         int countPerOneBox) {
        this.id = id;
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

    public static ModelResponse of(ModelDto dto) {
        return ModelResponse.builder()
                .id(dto.getId())
                .num(dto.getNum())
                .name(dto.getName())
                .width(dto.getWidth().toPlainString())
                .height(dto.getHeight().toPlainString())
                .inch(dto.getInch())
                .pages(dto.getPages())
                .internalPrice(dto.getInternalPrice())
                .abroadA1Price(dto.getAbroadA1Price().toPlainString())
                .abroadA2Price(dto.getAbroadA2Price().toPlainString())
                .abroadBPrice(dto.getAbroadBPrice().toPlainString())
                .coverPaperWidth(dto.getCoverPaperWidth())
                .coverPaperType(dto.getCoverPaperType())
                .coverPaperStandard(dto.getCoverPaperStandard())
                .coverPaperUsagePerOne(dto.getCoverPaperUsagePerOne().toPlainString())
                .innerPaperWidth(dto.getInnerPaperWidth())
                .innerPaperType(dto.getInnerPaperType())
                .innerPaperStandard(dto.getInnerPaperStandard())
                .innerPaperUsagePerOne(dto.getInnerPaperUsagePerOne().toPlainString())
                .bindingMethod(dto.getBindingMethod())
                .bindingPrice(dto.getBindingPrice())
                .coverSobu(dto.getCoverSobu())
                .coverDosu(dto.getCoverDosu())
                .innerSobu(dto.getInnerSobu())
                .innerDosu(dto.getInnerDosu())
                .brandPrintingMethod(dto.getBrandPrintingMethod())
                .brandPrintingSizeCm(dto.getBrandPrintingSizeCm())
                .brandPrintingSizeInch(dto.getBrandPrintingSizeInch())
                .boxType(dto.getBoxType())
                .countPerOneBox(dto.getCountPerOneBox())
                .build();
    }
}
