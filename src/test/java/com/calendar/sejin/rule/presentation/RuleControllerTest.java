package com.calendar.sejin.rule.presentation;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.rule.application.RuleDto;
import com.calendar.sejin.rule.application.RuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = RuleController.class)
class RuleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RuleService ruleService;

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("룰을 추가한다.")
    @Test
    void create() throws Exception {
        // given
        RuleCreateRequest createRequest = RuleCreateRequest.builder()
                .ruleId("TESTER")
                .name("테스터")
                .etc("테스트를 위한 권한")
                .build();
        String content = objectMapper.writeValueAsString(createRequest);

        // when & then
        when(ruleService.create(any())).thenReturn(
                RuleDto.builder()
                        .id(1L)
                        .ruleId(createRequest.getRuleId())
                        .name(createRequest.getName())
                        .etc(createRequest.getEtc())
                        .build()
        );
        mockMvc.perform(post("/api/v1/rule")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isCreated());

    }
}