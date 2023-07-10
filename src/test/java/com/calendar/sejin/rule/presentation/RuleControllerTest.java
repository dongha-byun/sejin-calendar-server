package com.calendar.sejin.rule.presentation;

import static org.hamcrest.Matchers.*;
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
    void create_rule() throws Exception {
        // given
        RuleCreateRequest createRequest = RuleCreateRequest.builder()
                .ruleId("TESTER")
                .name("테스터")
                .etc("테스트를 위한 권한")
                .build();
        String content = objectMapper.writeValueAsString(createRequest);

        // when & then
        when(ruleService.createRule(any())).thenReturn(
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

    @DisplayName("룰ID 는 필수항목이다.")
    @Test
    void create_rule_exception_with_no_ruleId() throws Exception {
        // given
        RuleCreateRequest createRequest = RuleCreateRequest.builder()
                .ruleId("")
                .name("테스터")
                .etc("테스트를 위한 권한")
                .build();
        String content = objectMapper.writeValueAsString(createRequest);

        // when & then
        when(ruleService.createRule(any())).thenReturn(
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
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("룰ID 는 필수항목입니다.")));
    }

    @DisplayName("룰이름 은 필수항목이다.")
    @Test
    void create_rule_exception_with_no_name() throws Exception {
        // given
        RuleCreateRequest createRequest = RuleCreateRequest.builder()
                .ruleId("TESTER")
                .name("")
                .etc("테스트를 위한 권한")
                .build();
        String content = objectMapper.writeValueAsString(createRequest);

        // when & then
        when(ruleService.createRule(any())).thenReturn(
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
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("룰이름 은 필수항목입니다.")));
    }

    @DisplayName("룰 정보를 수정한다.")
    @Test
    void update_rule_info() throws Exception {
        // given
        RuleUpdateRequest updateRequest = RuleUpdateRequest.builder()
                .name("테스터")
                .etc("테스트를 위한 권한")
                .build();
        String content = objectMapper.writeValueAsString(updateRequest);

        // when & then
        when(ruleService.changeRuleInfo(any(), any())).thenReturn(
                RuleDto.builder()
                        .id(1L)
                        .ruleId("TESTER")
                        .name(updateRequest.getName())
                        .etc(updateRequest.getEtc())
                        .build()
        );

        mockMvc.perform(put("/api/v1/rule/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("룰 정보를 삭제한다.")
    @Test
    void delete_rule() throws Exception {
        // given

        // when & then
        mockMvc.perform(delete("/api/v1/rule/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}