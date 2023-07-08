package com.calendar.sejin.model.application;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class ModelServiceTest {

    @Autowired
    ModelService modelService;

    @DisplayName("필수 항목만으로 모델 정보를 추가한다.")
    @Test
    void create_model_only_required() {
        // given
        ModelCreateDto createDto = getSimpleCreateDto("1호", "아름다운 강산");

        // when
        ModelDto modelDto = modelService.create(createDto);

        // then
        assertThat(modelDto.getId()).isNotNull();
        assertThat(modelDto.getNum()).isEqualTo("1호");
        assertThat(modelDto.getName()).isEqualTo("아름다운 강산");
        assertThat(modelDto.getWidth())
                .isNotNull()
                .isEqualTo(new BigDecimal("0.0"));
    }

    @DisplayName("모든 항목을 채워서 모델 정보를 추가한다.")
    @Test
    void create_model() {
        // given
        ModelCreateDto createDto = getSimpleCreateDto("1호", "아름다운 강산");

        // when
        ModelDto modelDto = modelService.create(createDto);

        // then
        assertThat(modelDto.getId()).isNotNull();
        assertThat(modelDto.getNum()).isEqualTo("1호");
        assertThat(modelDto.getName()).isEqualTo("아름다운 강산");
    }

    private ModelCreateDto getSimpleCreateDto(String num, String name) {
        return ModelCreateDto.builder()
                .num(num)
                .name(name)
                .build();
    }

    private ModelCreateDto getCreateDto(String num, String name) {
        return ModelCreateDto.builder()
                .num(num)
                .name(name)
                .width(new BigDecimal("23.5"))
                .height(new BigDecimal("18.5"))
                .inch("12 * 12")
                .pages(12)
                .internalPrice(120)
                .abroadA1Price(new BigDecimal("22.12"))
                .abroadA2Price(new BigDecimal("12.11"))
                .abroadBPrice(new BigDecimal("7.89"))
                .coverPaperWidth(120)
                .coverPaperType("대지")
                .coverPaperStandard("789*1001")
                .coverPaperUsagePerOne(new BigDecimal("3.1"))
                .innerPaperWidth(120)
                .innerPaperType("미색")
                .innerPaperStandard("123*633")
                .innerPaperUsagePerOne(new BigDecimal("2.2"))
                .bindingMethod("금구")
                .bindingPrice(1200)
                .coverSobu(4)
                .coverDosu(8)
                .innerSobu(8)
                .innerDosu(24)
                .brandPrintingMethod("에구다")
                .brandPrintingSizeCm(17)
                .brandPrintingSizeInch("11 * 12")
                .boxType("10-1")
                .countPerOneBox(35)
                .build();
    }
}