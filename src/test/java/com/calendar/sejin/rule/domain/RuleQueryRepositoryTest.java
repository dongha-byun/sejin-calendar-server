package com.calendar.sejin.rule.domain;

import static org.assertj.core.api.Assertions.*;

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
class RuleQueryRepositoryTest {

    @Autowired
    RuleRepository repository;

    @Autowired
    RuleQueryRepository queryRepository;

    @DisplayName("등록된 룰 정보를 모두 이름순으로 조회한다.")
    @Test
    void find_rule_all() {
        // given
        repository.save(new Rule("TESTER1", "테스터1", "비고"));
        repository.save(new Rule("GUEST", "게스트", "비고"));
        repository.save(new Rule("CEO", "대표이사", "비고"));

        // when
        List<Rule> rules = queryRepository.findRuleAll();

        // then
        assertThat(rules).hasSize(3)
                .extracting("alias", "name")
                .containsExactly(
                        tuple("GUEST", "게스트"),
                        tuple("CEO", "대표이사"),
                        tuple("TESTER1", "테스터1")
                );
    }
}