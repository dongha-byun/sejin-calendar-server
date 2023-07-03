package com.calendar.sejin.customcompany.domain;

import static com.calendar.sejin.customcompany.domain.QCustomCompany.customCompany;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CustomCompanyQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public CustomCompanyQueryRepository(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    public List<CustomCompany> searchCustomCompanyList(CompanyType type) {
        return jpaQueryFactory
                .selectFrom(customCompany)
                .where(
                        customCompany.type.eq(type)
                )
                .orderBy(
                        customCompany.id.desc()
                )
                .stream().toList();
    }
}
