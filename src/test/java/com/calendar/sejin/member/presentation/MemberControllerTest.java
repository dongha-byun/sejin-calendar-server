package com.calendar.sejin.member.presentation;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.member.application.MemberDto;
import com.calendar.sejin.member.application.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("신규 사용자를 추가한다.")
    void create_member() throws Exception {
        // given
        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
                "test-member", "test-member-password", "테스트 멤버",
                "서울시 영등포구", "010-1234-2222", "test@test.com", "22년 입사"
        );

        when(memberService.createMember(any())).thenReturn(
                new MemberDto(
                        10L, memberCreateRequest.getLoginId(), memberCreateRequest.getPassword(),
                        memberCreateRequest.getName(), memberCreateRequest.getAddress(),
                        memberCreateRequest.getTelNo(), memberCreateRequest.getEmail(),
                        memberCreateRequest.getEtc()
                )
        );

        // when & then
        mockMvc.perform(
                post("/api/v1/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(memberCreateRequest))
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(result -> result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("사용자 추가 시, 이름은 필수 값이다.")
    void create_member_exception_with_blank_name() throws Exception {
        // given
        MemberCreateRequest createRequest = MemberCreateRequest.builder()
                .loginId("test-member")
                .password("test-member-password")
                .build();

        // when & then
        mockMvc.perform(post("/api/v1/members")
                .content(objectMapper.writeValueAsString(createRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.name()))
                .andExpect(jsonPath("$.message").value("이름은 필수항목 입니다."));
    }
}