package com.calendar.sejin.customcompany.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class CustomCompanyQueryRepositoryTest {

    @Autowired
    CustomCompanyRepository repository;

    @Autowired
    CustomCompanyQueryRepository queryRepository;

    @DisplayName("거래처 분류로 거래처 목록 검색")
    @Test
    void find_custom_company_by_company_type() {
        // given
        CustomCompany com1 = repository.save(new CustomCompany("거래처1", CompanyType.AGENCY));
        CustomCompany com2 = repository.save(new CustomCompany("거래처2", CompanyType.AGENCY));
        CustomCompany com3 = repository.save(new CustomCompany("거래처3", CompanyType.MATERIAL));
        CustomCompany com4 = repository.save(new CustomCompany("거래처4", CompanyType.MATERIAL));

        // when
        List<CustomCompany> customCompanies = queryRepository.searchCustomCompanyList(CompanyType.MATERIAL);

        // then
        assertThat(customCompanies)
                .hasSize(2)
                .containsExactly(com4, com3);
    }
}