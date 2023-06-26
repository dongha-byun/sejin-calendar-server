package com.calendar.sejin.customcompany.application;

import com.calendar.sejin.customcompany.domain.CompanyType;
import com.calendar.sejin.customcompany.domain.CustomCompany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CustomCompanyDto {
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
    public CustomCompanyDto(Long id, String name, CompanyType type, String ceoName, String registrationNumber,
                            String address, String telNo, String fax, String email, String webHard, String discountType,
                            int discountRate, String etc) {
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

    public static CustomCompanyDto of(CustomCompany entity) {
        return CustomCompanyDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .ceoName(entity.getCeoName())
                .registrationNumber(entity.getRegistrationNumber())
                .address(entity.getAddress())
                .telNo(entity.getTelNo())
                .fax(entity.getFax())
                .email(entity.getEmail())
                .webHard(entity.getWebHard())
                .discountType(entity.getDiscountType())
                .discountRate(entity.getDiscountRate())
                .etc(entity.getEtc())
                .build();
    }
}
