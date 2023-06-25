package com.calendar.sejin.customcompany.presentation;

import com.calendar.sejin.customcompany.application.CustomCompanyUpdateDto;
import com.calendar.sejin.customcompany.domain.CompanyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomCompanyUpdateRequest {
    private String name;

    private String type;

    private String ceoName;

    private String registrationNumber;

    private String address;
    private String telNo;
    private String fax;
    private String email;
    private String webHard;

    private String discountType;
    private int discountRate;

    private String etc;

    public CustomCompanyUpdateDto toUpdateDto() {
        return CustomCompanyUpdateDto.builder()
                .name(name)
                .type(CompanyType.valueOf(type))
                .ceoName(ceoName)
                .registrationNumber(registrationNumber)
                .address(address)
                .telNo(telNo)
                .fax(fax)
                .email(email)
                .webHard(webHard)
                .discountType(discountType)
                .discountRate(discountRate)
                .etc(etc)
                .build();
    }
}
