package com.calendar.sejin.menu.domain;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "menus")
@Entity
public class Menu {

    @Id
    private String id;

    private String name;

    @Column(name = "menu_order")
    private int order;

    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_menu_id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Menu parent;

    @OneToMany(mappedBy = "parent")
    private final List<Menu> childMenus = new ArrayList<>();

    public Menu(String id, String name, String path, int order, Menu parent) {
        this.id = id;
        this.name = name;
        this.path = path;
        this.order = order;
        this.parent = parent;
        if(parent != null) {
            parent.addChildMenu(this);
        }
    }

    public void addChildMenu(Menu childMenu) {
        this.childMenus.add(childMenu);
    }
}
