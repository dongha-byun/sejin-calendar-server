package com.calendar.sejin.model.application;

import com.calendar.sejin.model.domain.Model;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ModelDto {
    private Long id;
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
    public ModelDto(Long id, String num, String name, BigDecimal width, BigDecimal height, String inch, int pages,
                    int internalPrice, BigDecimal abroadA1Price, BigDecimal abroadA2Price, BigDecimal abroadBPrice,
                    int coverPaperWidth, String coverPaperType, String coverPaperStandard,
                    BigDecimal coverPaperUsagePerOne,
                    int innerPaperWidth, String innerPaperType, String innerPaperStandard,
                    BigDecimal innerPaperUsagePerOne,
                    String bindingMethod, int bindingPrice, int coverSobu, int coverDosu, int innerSobu, int innerDosu,
                    String brandPrintingMethod, int brandPrintingSizeCm, String brandPrintingSizeInch, String boxType,
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

    public static ModelDto of(Model entity) {
        return ModelDto.builder()
                .id(entity.getId())
                .num(entity.getNum())
                .name(entity.getName())
                .width(entity.getSizeInfo().getWidth())
                .height(entity.getSizeInfo().getHeight())
                .inch(entity.getSizeInfo().getInch())
                .pages(entity.getSizeInfo().getPages())
                .internalPrice(entity.getPriceInfo().getInternalPrice())
                .abroadA1Price(entity.getPriceInfo().getAbroadA1Price().getPrice())
                .abroadA2Price(entity.getPriceInfo().getAbroadA2Price().getPrice())
                .abroadBPrice(entity.getPriceInfo().getAbroadBPrice().getPrice())
                .coverPaperWidth(entity.getCoverPaperInfo().getWeight())
                .coverPaperType(entity.getCoverPaperInfo().getType())
                .coverPaperStandard(entity.getCoverPaperInfo().getStandard())
                .coverPaperUsagePerOne(entity.getCoverPaperInfo().getUsagePerOne())
                .innerPaperWidth(entity.getInnerPaperInfo().getWeight())
                .innerPaperType(entity.getInnerPaperInfo().getType())
                .innerPaperStandard(entity.getInnerPaperInfo().getStandard())
                .innerPaperUsagePerOne(entity.getInnerPaperInfo().getUsagePerOne())
                .bindingMethod(entity.getBindingInfo().getMethod())
                .bindingPrice(entity.getBindingInfo().getPrice())
                .coverSobu(entity.getCoverPrintingInfo().getSobu())
                .coverDosu(entity.getCoverPrintingInfo().getDosu())
                .innerSobu(entity.getInnerPrintingInfo().getSobu())
                .innerDosu(entity.getInnerPrintingInfo().getDosu())
                .brandPrintingMethod(entity.getBrandPrintingInfo().getMethod())
                .brandPrintingSizeCm(entity.getBrandPrintingInfo().getSizeCm())
                .brandPrintingSizeInch(entity.getBrandPrintingInfo().getSizeInch())
                .boxType(entity.getBoxInfo().getType())
                .countPerOneBox(entity.getBoxInfo().getCountPerOneBox())
                .build();
    }
}
