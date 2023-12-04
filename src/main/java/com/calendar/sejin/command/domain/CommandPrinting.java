package com.calendar.sejin.command.domain;

import com.calendar.sejin.customcompany.domain.CustomCompany;
import com.calendar.sejin.model.domain.Model;
import com.calendar.sejin.model.domain.PaperInfo;
import com.calendar.sejin.model.domain.PrintingInfo;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "command_printing")
@Entity
public class CommandPrinting {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statementNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "printing_company_id")
    private CustomCompany printingCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    private String modelName;

    private int quantity;
    private int spareQuantity;
    private int totalQuantity;

    // 표지 : 용지무게, 용지지질, 용지규격, 부당용지소요량
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="weight", column=@Column(name = "cover_paper_weight")),
            @AttributeOverride(name="type", column=@Column(name = "cover_paper_type")),
            @AttributeOverride(name="standard", column=@Column(name = "cover_paper_standard")),
            @AttributeOverride(name="usagePerOne", column=@Column(name = "cover_paper_usagePerOne"))
    })
    private PaperInfo coverPaperInfo = new PaperInfo();

    // 내지 : 용지무게, 용지지질, 용지규격, 부당용지소요량
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="weight", column=@Column(name = "inner_paper_weight")),
            @AttributeOverride(name="type", column=@Column(name = "inner_paper_type")),
            @AttributeOverride(name="standard", column=@Column(name = "inner_paper_standard")),
            @AttributeOverride(name="usagePerOne", column=@Column(name = "inner_paper_usagePerOne"))
    })
    private PaperInfo innerPaperInfo = new PaperInfo();

    // 표지 : 소부 -> 인쇄할 때 필요한 판의 갯수, 도수 -> 인쇄할 때 사용하는 색을 몇 번 입히는가
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="sobu", column=@Column(name = "cover_sobu")),
            @AttributeOverride(name="dosu", column=@Column(name = "cover_dosu"))
    })
    private PrintingInfo coverPrintingInfo = new PrintingInfo();

    // 내지 : 소부 -> 인쇄할 때 필요한 판의 갯수, 도수 -> 인쇄할 때 사용하는 색을 몇 번 입히는가
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="sobu", column=@Column(name = "inner_sobu")),
            @AttributeOverride(name="dosu", column=@Column(name = "inner_dosu"))
    })
    private PrintingInfo innerPrintingInfo = new PrintingInfo();

    private String commandDate;
    private String content;
    private String etc;

    public CommandPrinting(String statementNumber, CustomCompany printingCompany, Model model, String modelName,
                           int quantity, int spareQuantity, int totalQuantity, PaperInfo coverPaperInfo,
                           PaperInfo innerPaperInfo, PrintingInfo coverPrintingInfo, PrintingInfo innerPrintingInfo,
                           String commandDate, String content, String etc) {
        this.statementNumber = statementNumber;
        this.printingCompany = printingCompany;
        this.model = model;
        this.modelName = modelName;
        this.quantity = quantity;
        this.spareQuantity = spareQuantity;
        this.totalQuantity = totalQuantity;
        this.coverPaperInfo = coverPaperInfo;
        this.innerPaperInfo = innerPaperInfo;
        this.coverPrintingInfo = coverPrintingInfo;
        this.innerPrintingInfo = innerPrintingInfo;
        this.commandDate = commandDate;
        this.content = content;
        this.etc = etc;
    }
}
