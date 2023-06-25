package com.calendar.sejin.customcompany.application;

import com.calendar.sejin.customcompany.domain.CompanyType;
import com.calendar.sejin.customcompany.domain.CustomCompany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomCompanyCreateDto {
    private String name;

    private CompanyType type;

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
    public CustomCompanyCreateDto(String name, CompanyType type, String ceoName, String registrationNumber,
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

    public CustomCompany toEntity() {
        return new CustomCompany(
                name, type, ceoName, registrationNumber, address, telNo, fax,
                email, webHard, discountType, discountRate, etc
        );
    }
}
