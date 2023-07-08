package com.calendar.sejin.model.presentation;

import com.calendar.sejin.model.application.ModelCreateDto;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ModelCreateRequest {

    @NotBlank(message = "호수는 필수 입력 값 입니다.")
    private String num;

    @NotBlank(message = "모델명은 필수 입력 값 입니다.")
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

    public ModelCreateDto toDto() {
        return ModelCreateDto.builder()
                .num(num)
                .name(name)
                .width(new BigDecimal(width))
                .height(new BigDecimal(height))
                .inch(inch)
                .pages(pages)
                .internalPrice(internalPrice)
                .abroadA1Price(new BigDecimal(abroadA1Price))
                .abroadA2Price(new BigDecimal(abroadA2Price))
                .abroadBPrice(new BigDecimal(abroadBPrice))
                .coverPaperWidth(coverPaperWidth)
                .coverPaperType(coverPaperType)
                .coverPaperStandard(coverPaperStandard)
                .coverPaperUsagePerOne(new BigDecimal(coverPaperUsagePerOne))
                .innerPaperWidth(innerPaperWidth)
                .innerPaperType(innerPaperType)
                .innerPaperStandard(innerPaperStandard)
                .innerPaperUsagePerOne(new BigDecimal(innerPaperUsagePerOne))
                .bindingMethod(bindingMethod)
                .bindingPrice(bindingPrice)
                .coverSobu(coverSobu)
                .coverDosu(coverDosu)
                .innerSobu(innerSobu)
                .innerDosu(innerDosu)
                .brandPrintingMethod(brandPrintingMethod)
                .brandPrintingSizeCm(brandPrintingSizeCm)
                .brandPrintingSizeInch(brandPrintingSizeInch)
                .boxType(boxType)
                .countPerOneBox(countPerOneBox)
                .build();
    }
}
