package com.calendar.sejin.diary.binding.domain;

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
@Table(name = "diary_binding")
@Entity
public class DiaryBinding {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "binding_company_id")
    private CustomCompany bindingCompany;

    private String bindingMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    private String modelName;

    private int quantity;

    private String brandName;

    private String workingDate;

    private int price;

    private String etc;

    public DiaryBinding(CustomCompany bindingCompany, String bindingMethod, Model model, String modelName, int quantity,
                        String brandName, String workingDate, int price, String etc) {
        this.bindingCompany = bindingCompany;
        this.bindingMethod = bindingMethod;
        this.model = model;
        this.modelName = modelName;
        this.quantity = quantity;
        this.brandName = brandName;
        this.workingDate = workingDate;
        this.price = price;
        this.etc = etc;
    }
}
