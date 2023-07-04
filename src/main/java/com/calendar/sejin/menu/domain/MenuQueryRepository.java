package com.calendar.sejin.menu.domain;

import static com.calendar.sejin.menu.domain.QMenu.menu;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MenuQueryRepository {
    private final JPAQueryFactory queryFactory;

    public MenuQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<Menu> findTopMenus() {
        return queryFactory.selectFrom(menu)
                .where(
                        menu.parent.isNull()
                )
                .orderBy(
                        orderByDefault()
                )
                .stream().toList();
    }

    public List<Menu> findChildMenus(Menu parent) {
        return queryFactory.selectFrom(menu)
                .where(
                        menu.parent.eq(parent)
                )
                .orderBy(
                        orderByDefault()
                )
                .stream().toList();
    }

    private OrderSpecifier<Integer> orderByDefault() {
        return menu.order.asc();
    }
}
