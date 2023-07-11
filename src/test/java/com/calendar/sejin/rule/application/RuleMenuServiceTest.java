package com.calendar.sejin.rule.application;

import static org.assertj.core.api.Assertions.*;

import com.calendar.sejin.menu.domain.Menu;
import com.calendar.sejin.menu.domain.MenuRepository;
import com.calendar.sejin.rule.domain.Rule;
import com.calendar.sejin.rule.domain.RuleRepository;
import java.util.Arrays;
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
class RuleMenuServiceTest {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    RuleRepository ruleRepository;

    @Autowired
    RuleMenuService ruleMenuService;

    @DisplayName("특정 룰에 접근 가능한 메뉴를 지정한다.")
    @Test
    void add_menu_of_rule() {
        // given
        // parent1
        // - child1
        // - child2
        // parent2
        // - child3
        // - - child3_1
        // - child4
        Rule rule = ruleRepository.save(new Rule("MASTER", "마스터 권한", "비고"));
        Menu parent1 = menuRepository.save(new Menu("PARENT1", "부모메뉴1", "/parent1-path", 0, null));
        Menu child1 = menuRepository.save(new Menu("CHILD1", "자식메뉴1", "/child-1-path", 0, parent1));
        Menu child2 = menuRepository.save(new Menu("CHILD2", "자식메뉴2", "/child-2-path", 1, parent1));
        Menu parent2 = menuRepository.save(new Menu("PARENT2", "부모메뉴2", "/parent2-path", 0, null));
        Menu child3 = menuRepository.save(new Menu("CHILD3", "자식메뉴3", "/child-3-path", 0, parent2));
        Menu child3_1 = menuRepository.save(new Menu("CHILD3_1", "자식메뉴3_1", "/child-3-1-path", 0, child3));
        Menu child4 = menuRepository.save(new Menu("CHILD4", "자식메뉴4", "/child-4-path", 1, parent2));

        // when
        RuleMenuInsertDto child1Dto = getRuleMenuInsertDto(child1, null);
        RuleMenuInsertDto child2Dto = getRuleMenuInsertDto(child2, null);
        RuleMenuInsertDto parent1Dto = getRuleMenuInsertDto(parent1, Arrays.asList(child1Dto, child2Dto));

        RuleMenuInsertDto child3_1Dto = getRuleMenuInsertDto(child3_1, null);
        RuleMenuInsertDto child3Dto = getRuleMenuInsertDto(child3, List.of(child3_1Dto));
        RuleMenuInsertDto child4Dto = getRuleMenuInsertDto(child4, null);
        RuleMenuInsertDto parent2Dto = getRuleMenuInsertDto(parent2, Arrays.asList(child3Dto, child4Dto));

        List<RuleMenuDto> ruleMenuDtos = ruleMenuService.addMenuOfRule(rule.getId(), Arrays.asList(parent1Dto, parent2Dto));

        // then
        assertThat(ruleMenuDtos).hasSize(7);
    }

    private RuleMenuInsertDto getRuleMenuInsertDto(Menu child1, List<RuleMenuInsertDto> subMenus) {
        return RuleMenuInsertDto.builder()
                .menuId(child1.getId())
                .subMenus(subMenus)
                .build();
    }
}