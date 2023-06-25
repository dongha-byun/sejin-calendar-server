package com.calendar.sejin.customcompany.application;

import com.calendar.sejin.customcompany.domain.CustomCompany;
import com.calendar.sejin.customcompany.domain.CustomCompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CustomCompanyService {
    private final CustomCompanyRepository customCompanyRepository;

    public CustomCompanyDto create(CustomCompanyCreateDto createDto) {
        CustomCompany customCompany = createDto.toEntity();
        CustomCompany savedCustomCompany = customCompanyRepository.save(customCompany);

        return CustomCompanyDto.of(savedCustomCompany);
    }

    public CustomCompanyDto update(Long id, CustomCompanyUpdateDto updateDto) {
        CustomCompany updateInfo = updateDto.toEntity();
        CustomCompany findCustomCompany = customCompanyRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("거래처 정보 조회 실패")
                );

        findCustomCompany.update(updateInfo);

        return CustomCompanyDto.of(findCustomCompany);
    }

    public void delete(Long id) {
        CustomCompany customCompany = customCompanyRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("거래처 정보 조회 실패")
                );
        customCompanyRepository.delete(customCompany);
    }
}
