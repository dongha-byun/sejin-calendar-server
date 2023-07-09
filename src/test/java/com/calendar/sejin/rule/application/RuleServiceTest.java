package com.calendar.sejin.rule.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class RuleServiceTest {

    @Autowired
    RuleService service;

    @DisplayName("룰을 추가한다.")
    @Test
    void create() {
        // given
        RuleCreateDto createDto = RuleCreateDto.builder()
                .ruleId("TESTER")
                .name("테스터")
                .etc("테스트계정에 부여하는 권한입니다.")
                .build();

        // when
        RuleDto ruleDto = service.create(createDto);

        // then
        assertThat(ruleDto.getId()).isNotNull();
    }
}