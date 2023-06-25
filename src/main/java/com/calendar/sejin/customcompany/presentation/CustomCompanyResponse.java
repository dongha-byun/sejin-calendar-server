package com.calendar.sejin.customcompany.presentation;

import com.calendar.sejin.customcompany.application.CustomCompanyDto;
import com.calendar.sejin.customcompany.domain.CompanyType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomCompanyResponse {
    private Long id;

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
    public CustomCompanyResponse(Long id, String name, CompanyType type, String ceoName, String registrationNumber,
                                 String address, String telNo, String fax, String email, String webHard,
                                 String discountType, int discountRate, String etc) {
        this.id = id;
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

    public static CustomCompanyResponse of(CustomCompanyDto dto) {
        return CustomCompanyResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .ceoName(dto.getCeoName())
                .registrationNumber(dto.getRegistrationNumber())
                .address(dto.getAddress())
                .telNo(dto.getTelNo())
                .fax(dto.getFax())
                .email(dto.getEmail())
                .webHard(dto.getWebHard())
                .discountType(dto.getDiscountType())
                .discountRate(dto.getDiscountRate())
                .etc(dto.getEtc())
                .build();
    }
}
