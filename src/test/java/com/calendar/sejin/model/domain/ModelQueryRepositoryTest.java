package com.calendar.sejin.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class ModelQueryRepositoryTest {

    @Autowired
    ModelQueryRepository queryRepository;

    @Autowired
    ModelRepository repository;

    @DisplayName("등록된 모든 Model 정보를 최근 등록 순으로 조회한다.")
    @Test
    void find_model_all() {
        // given
        repository.save(new Model("1호", "아름다운 강산"));
        repository.save(new Model("2호", "푸르른 강산"));
        repository.save(new Model("3호", "아름다운 바다"));

        // when
        List<Model> modelAll = queryRepository.findModelAll();

        // then
        assertThat(modelAll).hasSize(3)
                .extracting("num", "name")
                .containsExactly(
                        tuple("3호", "아름다운 바다"),
                        tuple("2호", "푸르른 강산"),
                        tuple("1호", "아름다운 강산")
                );
    }
}