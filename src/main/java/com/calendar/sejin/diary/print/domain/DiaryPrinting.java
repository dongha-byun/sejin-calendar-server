package com.calendar.sejin.diary.print.domain;

import com.calendar.sejin.customcompany.domain.CustomCompany;
import com.calendar.sejin.model.domain.Model;
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
@Table(name = "diary_printing")
@Entity
public class DiaryPrinting {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "printing_company_id")
    private CustomCompany printingCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
    private String modelName;

    private int totalQuantity;

    private String commandDate;

    private String releaseDate;

    public DiaryPrinting(CustomCompany printingCompany, Model model, String modelName, int totalQuantity,
                         String commandDate, String releaseDate) {
        this.printingCompany = printingCompany;
        this.model = model;
        this.modelName = modelName;
        this.totalQuantity = totalQuantity;
        this.commandDate = commandDate;
        this.releaseDate = releaseDate;
    }
}
