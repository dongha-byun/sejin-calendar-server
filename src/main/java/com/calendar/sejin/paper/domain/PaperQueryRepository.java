package com.calendar.sejin.paper.domain;

import com.calendar.sejin.paper.application.PaperDto;
import jakarta.persistence.EntityManager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PaperQueryRepository {
    private final EntityManager em;

    public List<PaperDto> findPaperDtoAll() {
        return em.createQuery(
                "select new com.calendar.sejin.paper.application.PaperDto("
                        + "p.id, p.weight, p.paperKind, p.standard"
                        + ") "
                        + "from Paper p "
                        + "order by p.id desc", PaperDto.class)
                .getResultList();
    }

    public List<String> findPaperKinds() {
        return em.createQuery(
                        "select distinct(p.paperKind) from Paper p", String.class
                )
                .getResultList();
    }

    public List<String> findStandards() {
        return em.createQuery(
                        "select distinct(p.standard) from Paper p", String.class
                )
                .getResultList();
    }
}
