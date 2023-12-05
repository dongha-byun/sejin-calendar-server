package com.calendar.sejin.command.paperdelivery.domain;

import com.calendar.sejin.customcompany.domain.CustomCompany;
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
@Table(name = "command_paper_delivery")
@Entity
public class CommandPaperDelivery {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_company_id")
    private CustomCompany paperCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "printing_company_id")
    private CustomCompany printingCompany;

    private int weight;

    private String paperKind;

    private String standard;

    private double quantity;

    private String commandDate;

    private String etc;

    public CommandPaperDelivery(CustomCompany paperCompany, CustomCompany printingCompany, int weight, String paperKind,
                                String standard, double quantity, String commandDate, String etc) {
        this.paperCompany = paperCompany;
        this.printingCompany = printingCompany;
        this.weight = weight;
        this.paperKind = paperKind;
        this.standard = standard;
        this.quantity = quantity;
        this.commandDate = commandDate;
        this.etc = etc;
    }
}
