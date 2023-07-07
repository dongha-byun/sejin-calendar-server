package com.calendar.sejin.model.domain;


import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class ModelRepositoryTest {

    @Autowired
    ModelRepository repository;

    @DisplayName("모델 정보 저장")
    @Test
    void save() {
        // given
        Model model = createModel("1호", "푸른 강산");

        // when
        Model savedModel = repository.save(model);

        // then
        assertThat(savedModel.getId()).isNotNull();
    }

    @DisplayName("모델 등록 시, 호수는 중복으로 입력할 수 없다.")
    @Test
    void num_unique() {
        // given
        Model model1 = createModel("2호", "아름다운 강산");
        repository.save(model1);

        // when & then
        Model model2 = createModel("2호", "어지러운 강산");
        assertThatThrownBy(
                () -> repository.save(model2)
        );
    }

    private Model createModel(String num, String name) {
        return Model.builder()
                .num(num)
                .name(name)
                .sizeInfo(
                        new SizeInfo(new BigDecimal("23.1"), new BigDecimal("22.1"), "9 * 1/6", 10)
                )
                .priceInfo(
                        new PriceInfo(
                                25, new BigDecimal("23.1"),
                                new BigDecimal("11.12"), new BigDecimal("9.12")
                        )
                )
                .innerPaperInfo(new PaperInfo(24, "미색", "788-1009", new BigDecimal("2.3")))
                .coverPaperInfo(new PaperInfo(24, "미색", "788-1009", new BigDecimal("2.3")))
                .bindingInfo(new BindingInfo("에구다", 9000))
                .innerPrintingInfo(new PrintingInfo(4, 8))
                .coverPrintingInfo(new PrintingInfo(8, 24))
                .brandPrintingInfo(new BrandPrintingInfo("에구다", 12, "12*12"))
                .boxInfo(new BoxInfo("10-1", 11))
                .build();
    }
}