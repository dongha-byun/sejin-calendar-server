package com.calendar.sejin.paper.presentation;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.paper.application.PaperDto;
import com.calendar.sejin.paper.application.PaperQueryService;
import com.calendar.sejin.paper.domain.Paper;
import com.calendar.sejin.paper.domain.PaperRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = PaperQueryController.class)
class PaperQueryControllerTest {

    @MockBean
    private PaperQueryService paperQueryService;

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("기초자료등록을 위해 등록된 용지 정보들을 확인한다.")
    @Test
    void test() throws Exception {
        // given
        List<PaperDto> dtoList = List.of(
                new PaperDto(1L, 100, "한지", "100*100"),
                new PaperDto(2L, 200, "골판지", "200*190"),
                new PaperDto(3L, 120, "대지", "1080*290"),
                new PaperDto(4L, 170, "철지", "1000*170")
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
                .andExpect(jsonPath("$.data", hasSize(4)));
    }
}