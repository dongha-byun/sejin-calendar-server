package com.calendar.sejin.rule.domain;

import com.calendar.sejin.menu.domain.Menu;
import jakarta.persistence.Embeddable;
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
@Table(name = "rule_menu_mapping")
@Entity
public class RuleMenu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rule_id")
    private Rule rule;

    private String menuId;
    private String menuName;

    @Builder
    public RuleMenu(Rule rule, String menuId, String menuName) {
        this.rule = rule;
        this.menuId = menuId;
        this.menuName = menuName;
    }

    public static RuleMenu create(Rule rule, Menu menu) {
        RuleMenu ruleMenu = RuleMenu.builder()
                .rule(rule)
                .menuId(menu.getId())
                .menuName(menu.getName())
                .build();
        rule.addRuleMenu(ruleMenu);

        return ruleMenu;
    }
}
