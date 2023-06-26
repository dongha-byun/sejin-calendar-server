package com.calendar.sejin.customcompany.presentation;

import com.calendar.sejin.customcompany.application.CustomCompanyCreateDto;
import com.calendar.sejin.customcompany.domain.CompanyType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomCompanyCreateRequest {

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

    @Builder
    public CustomCompanyCreateRequest(String name, String type, String ceoName, String registrationNumber,
                                      String address,
                                      String telNo, String fax, String email, String webHard, String discountType,
                                      int discountRate, String etc) {
        this.name = name;
        this.type = type;
        this.ceoName = ceoName;
        this.registrationNumber = registrationNumber;
        this.address = address;
        this.telNo = telNo;
        this.fax = fax;
        this.email = email;
        this.webHard = webHard;
        this.discountType = discountType;
        this.discountRate = discountRate;
        this.etc = etc;
    }

    public CustomCompanyCreateDto toCreateDto() {
        return CustomCompanyCreateDto.builder()
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
