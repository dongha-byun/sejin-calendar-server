package com.calendar.sejin.command.domain;

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
@Table(name = "command_binding")
@Entity
public class CommandBinding {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "binding_company_id")
    private CustomCompany bindingCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "printing_company_id")
    private CustomCompany printingCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    private String modelName;

    private String bindingMethod;

    private int quantity;

    private String commandDate;

    private String content;
    private String etc;

    public CommandBinding(CustomCompany bindingCompany, CustomCompany printingCompany, Model model, String modelName,
                          String bindingMethod, int quantity, String commandDate, String content, String etc) {
        this.bindingCompany = bindingCompany;
        this.printingCompany = printingCompany;
        this.model = model;
        this.modelName = modelName;
        this.bindingMethod = bindingMethod;
        this.quantity = quantity;
        this.commandDate = commandDate;
        this.content = content;
        this.etc = etc;
    }
}
