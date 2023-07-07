package com.calendar.sejin.model.presentation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.calendar.sejin.model.application.ModelDto;
import com.calendar.sejin.model.application.ModelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(controllers = ModelController.class)
class ModelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ModelService service;

    @Autowired
    ObjectMapper objectMapper;


    @DisplayName("모델 정보를 등록한다.")
    @Test
    void create_api() throws Exception {
        // given
        ModelCreateRequest modelCreateRequest = getModelCreateRequest("1호", "아름다운 강산");
        when(service.create(any())).thenReturn(
                getResultMockModelDto(modelCreateRequest)
        );
        String content = objectMapper.writeValueAsString(modelCreateRequest);

        // when & then
        mockMvc.perform(post("/api/v1/model")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    private ModelDto getResultMockModelDto(ModelCreateRequest request) {
        return ModelDto.builder()
                .id(1L)
                .num(request.getNum())
                .name(request.getName())
                .width(new BigDecimal(request.getWidth()))
                .height(new BigDecimal(request.getHeight()))
                .inch(request.getInch())
                .pages(request.getPages())
                .internalPrice(request.getInternalPrice())
                .abroadA1Price(new BigDecimal(request.getAbroadA1Price()))
                .abroadA2Price(new BigDecimal(request.getAbroadA2Price()))
                .abroadBPrice(new BigDecimal(request.getAbroadBPrice()))
                .coverPaperWidth(request.getCoverPaperWidth())
                .coverPaperType(request.getCoverPaperType())
                .coverPaperStandard(request.getCoverPaperStandard())
                .coverPaperUsagePerOne(new BigDecimal(request.getCoverPaperUsagePerOne()))
                .innerPaperWidth(request.getInnerPaperWidth())
                .innerPaperType(request.getInnerPaperType())
                .innerPaperStandard(request.getInnerPaperStandard())
                .innerPaperUsagePerOne(new BigDecimal(request.getInnerPaperUsagePerOne()))
                .bindingMethod(request.getBindingMethod())
                .bindingPrice(request.getBindingPrice())
                .coverSobu(request.getCoverSobu())
                .coverDosu(request.getCoverDosu())
                .innerSobu(request.getInnerSobu())
                .innerDosu(request.getInnerDosu())
                .brandPrintingMethod(request.getBrandPrintingMethod())
                .brandPrintingSizeCm(request.getBrandPrintingSizeCm())
                .brandPrintingSizeInch(request.getBrandPrintingSizeInch())
                .boxType(request.getBoxType())
                .countPerOneBox(request.getCountPerOneBox())
                .build();
    }

    private ModelCreateRequest getModelCreateRequest(String num, String name) {
        return new ModelCreateRequest(
                num, name, "23.5", "22.1", "110*12", 20,
                120, "11.1", "12.2", "3.14",
                60, "대지", "12*12", "2.89", 120, "모각", "80*66", "1.89",
                "금구", 1200, 4, 8, 8, 8,
                "에구다", 12, "11*12", "10-1", 20
        );
    }
}