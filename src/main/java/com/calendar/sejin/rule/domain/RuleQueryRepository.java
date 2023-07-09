package com.calendar.sejin.rule.domain;

import static com.calendar.sejin.rule.domain.QRule.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class RuleQueryRepository {

    private final JPAQueryFactory queryFactory;

    public RuleQueryRepository(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Rule> findRuleAll() {
        return queryFactory.selectFrom(rule)
                .orderBy(
                        rule.name.asc()
                )
                .stream().toList();
    }
}
