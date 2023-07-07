package com.calendar.sejin.model.domain;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "models")
@Entity
public class Model {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 호수, 모델명
    @Column(unique = true)
    private String num;
    private String name;

    // 가로, 세로, 규격(inch), 장수
    @Embedded
    private SizeInfo sizeInfo;

    // 가격표 : 국내가, 해외A1가, 해외A2가, 해외B가
    @Embedded
    private PriceInfo priceInfo;

    // 표지 : 용지무게, 용지지질, 용지규격, 부당용지소요량
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="weight", column=@Column(name = "cover_paper_weight")),
            @AttributeOverride(name="type", column=@Column(name = "cover_paper_type")),
            @AttributeOverride(name="standard", column=@Column(name = "cover_paper_standard")),
            @AttributeOverride(name="usagePerOne", column=@Column(name = "cover_paper_usagePerOne"))
    })
    private PaperInfo coverPaperInfo;

    // 내지 : 용지무게, 용지지질, 용지규격, 부당용지소요량
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="weight", column=@Column(name = "inner_paper_weight")),
            @AttributeOverride(name="type", column=@Column(name = "inner_paper_type")),
            @AttributeOverride(name="standard", column=@Column(name = "inner_paper_standard")),
            @AttributeOverride(name="usagePerOne", column=@Column(name = "inner_paper_usagePerOne"))
    })
    private PaperInfo innerPaperInfo;

    // 제본방식, 제본단가
    @Embedded
    private BindingInfo bindingInfo;

    // 표지 : 소부 -> 인쇄할 때 필요한 판의 갯수, 도수 -> 인쇄할 때 사용하는 색을 몇 번 입히는가
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="sobu", column=@Column(name = "cover_sobu")),
            @AttributeOverride(name="dosu", column=@Column(name = "cover_dosu"))
    })
    private PrintingInfo coverPrintingInfo;

    // 내지 : 소부 -> 인쇄할 때 필요한 판의 갯수, 도수 -> 인쇄할 때 사용하는 색을 몇 번 입히는가
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="sobu", column=@Column(name = "inner_sobu")),
            @AttributeOverride(name="dosu", column=@Column(name = "inner_dosu"))
    })
    private PrintingInfo innerPrintingInfo;

    // 상호쇄입방식, 상호규격 cm, 상호규격 inch
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="method", column=@Column(name = "brand_printing_method")),
            @AttributeOverride(name="sizeCm", column=@Column(name = "brand_size_cm")),
            @AttributeOverride(name="sizeInch", column=@Column(name = "brand_size_inch"))
    })
    private BrandPrintingInfo brandPrintingInfo;

    // Box, 부수/Box
    @Embedded
    private BoxInfo boxInfo;

    @Builder
    public Model(String num, String name,
                 SizeInfo sizeInfo, PriceInfo priceInfo, PaperInfo coverPaperInfo,
                 PaperInfo innerPaperInfo, BindingInfo bindingInfo, PrintingInfo coverPrintingInfo,
                 PrintingInfo innerPrintingInfo, BrandPrintingInfo brandPrintingInfo, BoxInfo boxInfo) {
        this.num = num;
        this.name = name;
        this.sizeInfo = sizeInfo;
        this.priceInfo = priceInfo;
        this.coverPaperInfo = coverPaperInfo;
        this.innerPaperInfo = innerPaperInfo;
        this.bindingInfo = bindingInfo;
        this.coverPrintingInfo = coverPrintingInfo;
        this.innerPrintingInfo = innerPrintingInfo;
        this.brandPrintingInfo = brandPrintingInfo;
        this.boxInfo = boxInfo;
    }
}
