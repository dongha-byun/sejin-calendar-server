package com.calendar.sejin.menu.presentation;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.menu.application.MainMenuQueryDto;
import com.calendar.sejin.menu.application.MenuQueryService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("test")
@WebMvcTest(controllers = MenuQueryController.class)
class MenuQueryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MenuQueryService queryService;

    @DisplayName("메인화면에 사용할 메뉴를 한 번에 조회한다.")
    @Test
    void test() throws Exception {
        // given
        MainMenuQueryDto sub1 = new MainMenuQueryDto("sub1", "하단메뉴1", 0, "/sub1", null);
        MainMenuQueryDto sub2 = new MainMenuQueryDto("sub2", "하단메뉴2", 1, "/sub2", null);
        MainMenuQueryDto sub3 = new MainMenuQueryDto("sub3", "하단메뉴3", 2, "/sub3", null);
        MainMenuQueryDto top =
                new MainMenuQueryDto("top1", "상단메뉴1", 0, "/top1", List.of(sub1, sub2, sub3));
        when(queryService.findMainMenus()).thenReturn(List.of(top));

        // when & then
        mockMvc.perform(get("/api/v1//mainMenus")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].childMenus", hasSize(3)));
    }
}