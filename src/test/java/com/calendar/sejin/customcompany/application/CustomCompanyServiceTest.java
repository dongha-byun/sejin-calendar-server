package com.calendar.sejin.customcompany.application;

import static org.assertj.core.api.Assertions.*;

import com.calendar.sejin.customcompany.domain.CompanyType;
import com.calendar.sejin.customcompany.domain.CustomCompany;
import com.calendar.sejin.customcompany.domain.CustomCompanyRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class CustomCompanyServiceTest {

    @Autowired
    CustomCompanyService service;

    @Autowired
    CustomCompanyRepository repository;

    @Test
    @DisplayName("거래처를 등록한다.")
    void create_custom_company() {
        // given
        CustomCompanyCreateDto customCompanyCreateDto = new CustomCompanyCreateDto(
                "테스트 거래처1", CompanyType.AGENCY, "총판대표", "999-99-00000",
                "서울시 영등포구 1", "010-2222-4444", "031-222-4343", "test@test.com",
                "test@webhard.com", "국내", 15, "신규 거래처");

        // when
        CustomCompanyDto customCompanyDto = service.create(customCompanyCreateDto);

        // then
        assertThat(customCompanyDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("거래처 정보를 삭제한다.")
    void delete_custom_company() {
        // given
        CustomCompanyCreateDto customCompanyCreateDto = new CustomCompanyCreateDto(
                "테스트 거래처1", CompanyType.AGENCY, "총판대표", "999-99-00000",
                "서울시 영등포구 1", "010-2222-4444", "031-222-4343", "test@test.com",
                "test@webhard.com", "국내", 15, "신규 거래처");
        CustomCompanyDto customCompanyDto = service.create(customCompanyCreateDto);

        // when
        service.delete(customCompanyDto.getId());

        // then
        Optional<CustomCompany> findCustom = repository.findById(customCompanyDto.getId());
        assertThat(findCustom.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("거래처 정보를 수정한다.")
    void update_custom_company() {
        // given
        CustomCompanyCreateDto customCompanyCreateDto = new CustomCompanyCreateDto(
                "테스트 거래처1", CompanyType.AGENCY, "총판대표", "999-99-00000",
                "서울시 영등포구 1", "010-2222-4444", "031-222-4343", "test@test.com",
                "test@webhard.com", "국내", 15, "신규 거래처");
        CustomCompanyDto customCompanyDto = service.create(customCompanyCreateDto);

        CustomCompanyUpdateDto customCompanyUpdateDto = new CustomCompanyUpdateDto(
                "테스트 거래처1", CompanyType.AGENCY, "총판대표", "999-99-00000",
                "서울시 영등포구 1", "010-2222-4444", "031-222-4343", "test@test.com",
                "test@webhard.com", "국내", 15, "신규 거래처");

        // when
        service.update(customCompanyDto.getId(), customCompanyUpdateDto);

        // then
        CustomCompany findEntity = repository.findById(customCompanyDto.getId()).orElseThrow();
        assertThat(findEntity).isNotNull();

    }
}