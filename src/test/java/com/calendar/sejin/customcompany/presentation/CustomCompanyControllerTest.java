package com.calendar.sejin.customcompany.presentation;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.customcompany.application.CustomCompanyDto;
import com.calendar.sejin.customcompany.application.CustomCompanyService;
import com.calendar.sejin.customcompany.domain.CompanyType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomCompanyController.class)
class CustomCompanyControllerTest {

    @MockBean
    private CustomCompanyService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("신규 거래처 정보를 등록한다.")
    @Test
    void create_test() throws Exception {
        // given
        CustomCompanyDto createDto = getCreateDto();
        CustomCompanyCreateRequest createRequest = getCreateRequest();

        when(service.create(any())).thenReturn(createDto);

        // when & then
        mockMvc.perform(
                        post("/api/v1/custom-company")
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                                .content(objectMapper.writeValueAsString(createRequest))
                )
                .andExpect(status().isCreated());

    }

    private CustomCompanyCreateRequest getCreateRequest() {
        return CustomCompanyCreateRequest.builder()
                .name("테스트 거래처")
                .type(CompanyType.AGENCY.name())
                .ceoName("테스트 대표")
                .registrationNumber("222-11-33322")
                .address("서울시 영등포")
                .telNo("010-2222-3333")
                .fax("031-222-4444")
                .email("test@test.com")
                .webHard("test@webhard.com")
                .discountType("국내")
                .discountRate(15)
                .etc("기타")
                .build();
    }

    private CustomCompanyDto getCreateDto() {
        return CustomCompanyDto.builder()
                .id(1L)
                .name("테스트 거래처")
                .type(CompanyType.AGENCY)
                .ceoName("테스트 대표")
                .registrationNumber("222-11-33322")
                .address("서울시 영등포")
                .telNo("010-2222-3333")
                .fax("031-222-4444")
                .email("test@test.com")
                .webHard("test@webhard.com")
                .discountType("국내")
                .discountRate(15)
                .etc("기타")
                .build();
    }
}