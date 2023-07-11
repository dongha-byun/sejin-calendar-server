package com.calendar.sejin.rule.application;

import com.calendar.sejin.menu.domain.Menu;
import com.calendar.sejin.menu.domain.MenuRepository;
import com.calendar.sejin.rule.domain.Rule;
import com.calendar.sejin.rule.domain.RuleMenu;
import com.calendar.sejin.rule.domain.RuleRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RuleMenuService {
    private final RuleRepository ruleRepository;
    private final MenuRepository menuRepository;

    public List<RuleMenuDto> addMenuOfRule(Long ruleId, List<RuleMenuInsertDto> menuInfoList) {
        Rule findRule = ruleRepository.findById(ruleId)
                .orElseThrow(
                        () -> new IllegalArgumentException("룰 정보 조회 실패")
                );

        // 하위 계층 다 돌면서 flat 하게 RuleMenu entity 만들어서 rule 에 add 처리해야함
        List<String> allMenuIds = convertAllMenuIdList(menuInfoList);

        List<Menu> allMenu = menuRepository.findAllMenus(allMenuIds);
        List<RuleMenu> ruleMenus = createMenuListOfRule(findRule, allMenu);

        return ruleMenus.stream()
                .map(RuleMenuDto::of)
                .toList();
    }

    private List<RuleMenu> createMenuListOfRule(Rule findRule, List<Menu> allMenu) {
        return allMenu.stream()
                .map(
                        menu -> RuleMenu.create(findRule, menu)
                ).toList();
    }

    private List<String> convertAllMenuIdList(List<RuleMenuInsertDto> menuInfoList) {
        return menuInfoList.stream()
                .map(RuleMenuInsertDto::getAllMenuIds)
                .flatMap(ruleIds -> Arrays.stream(ruleIds.toArray(new String[0])))
                .toList();
    }
}
