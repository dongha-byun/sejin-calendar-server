package com.calendar.sejin.menu.application;

import static org.assertj.core.api.Assertions.*;

import com.calendar.sejin.menu.domain.Menu;
import com.calendar.sejin.menu.domain.MenuRepository;
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
class MenuQueryServiceTest {

    @Autowired
    MenuRepository repository;

    @Autowired
    MenuQueryService service;

    @DisplayName("메인 메뉴 전체 조회 - 상단 메뉴 바")
    @Test
    void find_main_menu() {
        // given
        Menu topMenu1 = repository.save(new Menu("topMenu1", "상단 메뉴 1", "/top1", 0, null));
        Menu subMenu1 = repository.save(new Menu("subMenu1", "서브 메뉴 1", "/sub1", 0, topMenu1));
        Menu subMenu2 = repository.save(new Menu("subMenu2", "서브 메뉴 2", "/sub2", 1, topMenu1));
        Menu subMenu3 = repository.save(new Menu("subMenu3", "서브 메뉴 3", "/sub3", 2, topMenu1));

        // when
        List<MainMenuQueryDto> mainMenus = service.findMainMenus();

        // then
        assertThat(mainMenus).hasSize(1)
                .extracting("id", "name")
                .containsExactly(
                        tuple(topMenu1.getId(), topMenu1.getName())
                );
        MainMenuQueryDto mainMenu = mainMenus.get(0);
        assertThat(mainMenu.getChildMenus()).hasSize(3)
                .extracting("id", "name", "path")
                .containsExactly(
                        tuple(subMenu1.getId(), subMenu1.getName(), subMenu1.getPath()),
                        tuple(subMenu2.getId(), subMenu2.getName(), subMenu2.getPath()),
                        tuple(subMenu3.getId(), subMenu3.getName(), subMenu3.getPath())
                );
    }
}