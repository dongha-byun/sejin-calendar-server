package com.calendar.sejin.model.domain;

import static com.calendar.sejin.model.domain.QModel.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ModelQueryRepository {
    private final JPAQueryFactory queryFactory;

    public ModelQueryRepository(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    public List<Model> findModelAll() {
        return queryFactory
                .selectFrom(model)
                .orderBy(
                        model.id.desc()
                )
                .stream().toList();
    }
}
