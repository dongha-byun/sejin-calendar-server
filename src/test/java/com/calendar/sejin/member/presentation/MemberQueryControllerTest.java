package com.calendar.sejin.member.presentation;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.member.application.MemberDto;
import com.calendar.sejin.member.application.MemberQueryService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MemberQueryController.class)
class MemberQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberQueryService memberQueryService;

    @Test
    @DisplayName("사용자 목록을 조회한다.")
    void find_all_members() throws Exception {
        // given
        List<MemberDto> memberDtos = Arrays.asList(
                new MemberDto(1L, "memberDto1", "member1!", "멤버1", "서울시 영등포구", "010-2222-3333", "member1@test,com",
                        "22년 입사"),
                new MemberDto(2L, "memberDto2", "member2@", "멤버2", "서울시 영등포구", "010-4444-5555", "member2@test,com",
                        "21년 입사")
        );
        when(memberQueryService.findMemberAll()).thenReturn(memberDtos);

        // when & then
        mockMvc.perform(
                        get("/api/v1/members")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
        ;
    }
}