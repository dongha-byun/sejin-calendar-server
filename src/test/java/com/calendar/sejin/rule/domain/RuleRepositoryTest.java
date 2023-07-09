package com.calendar.sejin.rule.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class RuleRepositoryTest {

    @Autowired
    RuleRepository repository;

    @DisplayName("룰 ID 는 중복일 수 없다.")
    @Test
    void rule_id_unique() {
        // given
        Rule rule1 = new Rule("RULE_1", "권한1", "비고");
        Rule rule1_duplicate = new Rule("RULE_1", "권한1", "비고");

        repository.save(rule1);

        // when & then
        assertThatThrownBy(
                () -> repository.save(rule1_duplicate)
        );
    }
}