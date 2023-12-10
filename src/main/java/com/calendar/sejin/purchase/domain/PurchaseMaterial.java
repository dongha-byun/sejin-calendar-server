package com.calendar.sejin.purchase.domain;

import com.calendar.sejin.customcompany.domain.CustomCompany;
import com.calendar.sejin.material.domain.MaterialType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "purchase_materials")
@Entity
public class PurchaseMaterial {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private MaterialType materialType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private CustomCompany company;

    private String standard1;
    private String standard2;

    private String history;

    private String color;

    private int quantity;

    private LocalDate purchaseDate;
    private LocalDate deliveryRequestDate;

    private String etc;

    public PurchaseMaterial(MaterialType materialType, CustomCompany company, String standard1, String standard2,
                            String history, String color, int quantity, LocalDate purchaseDate,
                            LocalDate deliveryRequestDate, String etc) {
        this.materialType = materialType;
        this.company = company;
        this.standard1 = standard1;
        this.standard2 = standard2;
        this.history = history;
        this.color = color;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.deliveryRequestDate = deliveryRequestDate;
        this.etc = etc;
    }
}
