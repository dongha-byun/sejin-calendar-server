package com.calendar.sejin.customcompany.application;

import com.calendar.sejin.customcompany.domain.CompanyType;
import com.calendar.sejin.customcompany.domain.CustomCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
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

    public static CustomCompanyDto of(CustomCompany entity) {
        return new CustomCompanyDto(
                entity.getId(), entity.getName(), entity.getType(), entity.getCeoName(),
                entity.getRegistrationNumber(), entity.getAddress(), entity.getTelNo(),
                entity.getFax(), entity.getEmail(), entity.getWebHard(),
                entity.getDiscountType(), entity.getDiscountRate(), entity.getEtc()
        );
    }
}
