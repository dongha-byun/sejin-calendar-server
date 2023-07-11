package com.calendar.sejin.menu.domain;

import static org.assertj.core.api.Assertions.*;

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
class MenuRepositoryTest {

    @Autowired
    MenuRepository menuRepository;


    @DisplayName("특정 메뉴 ID 목록을 조회한다.")
    @Test
    void find_menus_by_in_menu_ids() {
        // given
        Menu parentMenu = menuRepository.save(new Menu("TEST_PARENT_MENU", "테스트_부모_메뉴", "/test-parent-path", 0, null));
        Menu childMenu1 = menuRepository.save(new Menu("TEST_CHILD_MENU_1", "테스트_자식_메뉴_1", "/test-child-path1", 0, parentMenu));
        Menu childMenu2 = menuRepository.save(new Menu("TEST_CHILD_MENU_2", "테스트_자식_메뉴_2", "/test-child-path2", 1, parentMenu));
        Menu childMenu3 = menuRepository.save(new Menu("TEST_CHILD_MENU_3", "테스트_자식_메뉴_3", "/test-child-path3", 2, parentMenu));

        // when
        List<Menu> menus = menuRepository.findAllMenus(
                Arrays.asList(
                        parentMenu.getId(), childMenu1.getId(),
                        childMenu2.getId(), childMenu3.getId()
                )
        );

        // then
        assertThat(menus).hasSize(4)
                .extracting("id", "name")
                .containsExactly(
                        tuple("TEST_PARENT_MENU", "테스트_부모_메뉴"),
                        tuple("TEST_CHILD_MENU_1", "테스트_자식_메뉴_1"),
                        tuple("TEST_CHILD_MENU_2", "테스트_자식_메뉴_2"),
                        tuple("TEST_CHILD_MENU_3", "테스트_자식_메뉴_3")
                );
    }
}