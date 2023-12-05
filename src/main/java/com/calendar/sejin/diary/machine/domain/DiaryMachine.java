package com.calendar.sejin.diary.machine.domain;

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
@Table(name = "diary_machine")
@Entity
public class DiaryMachine {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String machine;

    private String workingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;
    private String modelName;

    private int quantity;

    private String brandName;

    private String etc;

    public DiaryMachine(String machine, String workingDate, Model model, String modelName,
                        int quantity, String brandName, String etc) {
        this.machine = machine;
        this.workingDate = workingDate;
        this.model = model;
        this.modelName = modelName;
        this.quantity = quantity;
        this.brandName = brandName;
        this.etc = etc;
    }
}
