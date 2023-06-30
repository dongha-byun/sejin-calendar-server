package com.calendar.sejin.paper.presentation;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.paper.application.PaperDto;
import com.calendar.sejin.paper.application.PaperQueryService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@WebMvcTest(controllers = PaperQueryController.class)
class PaperQueryControllerTest {

    @MockBean
    private PaperQueryService paperQueryService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("기초자료로 등록된 용지 정보들을 확인한다.")
    @Test
    void find_paper_all() throws Exception {
        // given
        List<PaperDto> dtoList = List.of(
                new PaperDto(4L, 100, "한지", "100*100"),
                new PaperDto(3L, 200, "골판지", "200*190"),
                new PaperDto(2L, 120, "대지", "1080*290"),
                new PaperDto(1L, 170, "철지", "1000*170")
        );

        when(paperQueryService.findPaperDtoAll()).thenReturn(dtoList);

        // when
        ResultActions resultActions = mockMvc.perform(
                get("/api/v1/papers")
                    .content(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print());

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasSize(4)))
                .andExpect(jsonPath("$.data[*].id", hasItems(
                        4, 3, 2, 1
                )));
    }

    @DisplayName("현재까지 등록된 지질정보와 규격정보 목록을 조회한다.")
    @Test
    void find_paper_kind_and_standard() throws Exception {
        // given
        List<PaperDto> dtoList = List.of(
                new PaperDto(4L, 100, "한지", "100*100"),
                new PaperDto(3L, 200, "골판지", "1080*290"),
                new PaperDto(2L, 120, "골판지", "1080*290"),
                new PaperDto(1L, 170, "철지", "100*100")
        );

        when(paperQueryService.findPaperKinds()).thenReturn(List.of("한지", "골판지", "철지"));
        when(paperQueryService.findStandards()).thenReturn(List.of("100*100", "1080*290"));

        // when
        ResultActions resultActions = mockMvc.perform(
                        get("/api/v1/papers")
                                .content(MediaType.APPLICATION_JSON_VALUE)
                )
                .andDo(print());

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paperKinds", hasSize(3)))
                .andExpect(jsonPath("$.paperKinds", hasItems("한지", "골판지", "철지")))
                .andExpect(jsonPath("$.standards", hasSize(2)))
                .andExpect(jsonPath("$.standards", hasItems("100*100", "1080*290")))
                ;
    }
}