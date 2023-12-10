package com.calendar.sejin.purchase.domain;

import com.calendar.sejin.customcompany.domain.CustomCompany;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "purchase_papers")
@Entity
public class PurchasePaper {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_company_id")
    private CustomCompany paperCompany;

    private int weight;
    private String paperKind;
    private String standard;

    private int quantity;
    private LocalDate purchaseDate;
    private String etc;

    public PurchasePaper(CustomCompany paperCompany, int weight, String paperKind, String standard,
                         int quantity, LocalDate purchaseDate, String etc) {
        this.paperCompany = paperCompany;
        this.weight = weight;
        this.paperKind = paperKind;
        this.standard = standard;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.etc = etc;
    }
}
