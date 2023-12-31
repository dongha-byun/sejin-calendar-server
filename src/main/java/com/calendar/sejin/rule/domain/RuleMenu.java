package com.calendar.sejin.rule.domain;

import com.calendar.sejin.menu.domain.Menu;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "rule_menu")
@Entity
public class RuleMenu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id")
    private Rule rule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @Builder
    public RuleMenu(Rule rule, Menu menu) {
        this.rule = rule;
        this.menu = menu;
    }

    public static RuleMenu create(Rule rule, Menu menu) {
        RuleMenu ruleMenu = RuleMenu.builder()
                .rule(rule)
                .menu(menu)
                .build();
        rule.addRuleMenu(ruleMenu);

        return ruleMenu;
    }
}
