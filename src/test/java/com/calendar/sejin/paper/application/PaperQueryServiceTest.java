package com.calendar.sejin.paper.application;

import static org.assertj.core.api.Assertions.*;

import com.calendar.sejin.paper.domain.Paper;
import com.calendar.sejin.paper.domain.PaperRepository;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class PaperQueryServiceTest {

    @Autowired
    PaperRepository paperRepository;

    @Autowired
    PaperQueryService service;

    @DisplayName("기초자료로 등록된 용지 정보들을 조회한다.")
    @Test
    void find_all_papers() {
        // given
        Paper paper1 = paperRepository.save(new Paper(100, "용지1", "100*100"));
        Paper paper2 = paperRepository.save(new Paper(200, "용지2", "200*100"));
        Paper paper3 = paperRepository.save(new Paper(300, "용지3", "300*100"));

        // when
        List<PaperDto> papers = service.findPaperDtoAll();

        // then
        assertThat(papers).hasSize(3)
                .extracting("id", "weight", "paperKind", "standard")
                .containsExactly(
                        tuple(paper3.getId(), 300, "용지3", "300*100"),
                        tuple(paper2.getId(), 200, "용지2", "200*100"),
                        tuple(paper1.getId(), 100, "용지1", "100*100")
                );
    }

    @DisplayName("현재까지 등록된 지질 정보를 중복없이 조회한다.")
    @Test
    void find_paper_kinds() {
        // given
        paperRepository.save(new Paper(100, "용지1", "100*100"));
        paperRepository.save(new Paper(200, "용지1", "200*100"));
        paperRepository.save(new Paper(300, "용지2", "300*100"));

        // when
        List<String> paperKinds = service.findPaperKinds();

        // then
        assertThat(paperKinds)
                .hasSize(2)
                .containsExactly("용지1", "용지2");
    }

    @DisplayName("현재까지 등록된 규격 정보를 중복없이 조회한다.")
    @Test
    void find_standards() {
        // given
        paperRepository.save(new Paper(100, "용지1", "100*100"));
        paperRepository.save(new Paper(200, "용지3", "300*100"));
        paperRepository.save(new Paper(300, "용지2", "300*100"));

        // when
        List<String> standards = service.findStandards();

        // then
        assertThat(standards)
                .hasSize(2)
                .containsExactly("100*100", "300*100");
    }
}