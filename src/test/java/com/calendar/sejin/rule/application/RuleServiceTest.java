package com.calendar.sejin.rule.application;

import static org.assertj.core.api.Assertions.*;

import com.calendar.sejin.rule.domain.Rule;
import com.calendar.sejin.rule.domain.RuleRepository;
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

    @Autowired
    RuleRepository ruleRepository;

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
        RuleDto ruleDto = service.createRule(createDto);

        // then
        assertThat(ruleDto.getId()).isNotNull();
    }

    @DisplayName("룰 정보를 수정한다.")
    @Test
    void change_rule_info() {
        // given
        Rule savedRule = ruleRepository.save(new Rule("TESTER", "룰 이름", "비고"));
        RuleUpdateDto updateDto = RuleUpdateDto.builder()
                .name("업데이트 룰 이름")
                .etc("룰 설명 수정")
                .build();

        // when
        RuleDto updatedRuleDto = service.changeRuleInfo(savedRule.getId(), updateDto);

        // then
        assertThat(updatedRuleDto.getId()).isEqualTo(savedRule.getId());
        assertThat(updatedRuleDto.getRuleId()).isEqualTo("TESTER");
        assertThat(updatedRuleDto.getName()).isEqualTo("업데이트 룰 이름");
        assertThat(updatedRuleDto.getEtc()).isEqualTo("룰 설명 수정");
    }

    @DisplayName("룰 정보를 삭제한다.")
    @Test
    void delete() {
        // given
        Rule savedRule = ruleRepository.save(new Rule("TESTER", "룰 이름", "비고"));

        // when
        service.deleteRule(savedRule.getId());

        // then
        assertThatThrownBy(
                () -> ruleRepository.findById(savedRule.getId())
                        .orElseThrow(
                                () -> new IllegalArgumentException("룰 정보 조회 실패")
                        )
        ).isInstanceOf(IllegalArgumentException.class);
    }
}