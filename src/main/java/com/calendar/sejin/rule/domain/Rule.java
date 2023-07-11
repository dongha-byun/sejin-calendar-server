package com.calendar.sejin.rule.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "rules")
@Entity
public class Rule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String alias;
    private String name;
    private String etc;

    @OneToMany(mappedBy = "rule", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private final List<RuleMenu> ruleMenus = new ArrayList<>();

    @Builder
    public Rule(String alias, String name, String etc) {
        this.alias = alias;
        this.name = name;
        this.etc = etc;
    }

    public void changeRuleInfo(String name, String etc) {
        this.name = name;
        this.etc = etc;
    }

    public void addRuleMenu(RuleMenu ruleMenu) {
        this.ruleMenus.add(ruleMenu);
    }
}
