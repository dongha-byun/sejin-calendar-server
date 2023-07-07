package com.calendar.sejin.menu.domain;

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
class MenuQueryRepositoryTest {

    @Autowired
    MenuQueryRepository queryRepository;

    @Autowired
    MenuRepository repository;

    @DisplayName("최산단 메뉴 조회")
    @Test
    void find_top_menu() {
        // given
        Menu topMenu1 = repository.save(new Menu("topMenu1", "상단 메뉴 1", "/top1", 0, null));
        Menu topMenu2 = repository.save(new Menu("topMenu2", "상단 메뉴 2", "/top2", 1, null));
        Menu subMenu1 = repository.save(new Menu("subMenu1", "서브 메뉴 1", "/sub1", 0, topMenu1));
        Menu subMenu2 = repository.save(new Menu("subMenu2", "서브 메뉴 2", "/sub2", 1, topMenu2));
        Menu subMenu3 = repository.save(new Menu("subMenu3", "서브 메뉴 3", "/sub3", 2, topMenu2));

        // when
        List<Menu> topMenus = queryRepository.findTopMenus();

        // then
        assertThat(topMenus)
                .hasSize(2)
                .containsExactly(topMenu1, topMenu2);
    }

    @DisplayName("특정 메뉴의 하위 메뉴 조회")
    @Test
    void find_child_menus() {
        // given
        Menu topMenu1 = repository.save(new Menu("topMenu1", "상단 메뉴 1", "/top1", 0, null));
        Menu topMenu2 = repository.save(new Menu("topMenu2", "상단 메뉴 2", "/top2", 1, null));
        Menu subMenu1 = repository.save(new Menu("subMenu1", "서브 메뉴 1", "/sub1", 0, topMenu1));
        Menu subMenu2 = repository.save(new Menu("subMenu2", "서브 메뉴 2", "/sub2", 1, topMenu2));
        Menu subMenu3 = repository.save(new Menu("subMenu3", "서브 메뉴 3", "/sub3", 2, topMenu2));

        // when
        List<Menu> childMenus = queryRepository.findChildMenus(topMenu2);

        // then
        assertThat(childMenus)
                .hasSize(2)
                .containsExactly(subMenu2, subMenu3);
    }
}