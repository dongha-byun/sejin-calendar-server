package com.calendar.sejin.customcompany.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "custom_company")
@Entity
public class CustomCompany {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public CustomCompany(String name, CompanyType type, String ceoName, String registrationNumber, String address,
                         String telNo, String fax, String email, String webHard, String discountType, int discountRate,
                         String etc) {
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

    public static CustomCompany create(String name, CompanyType type, String ceoName, String registrationNumber, String address,
                                       String telNo, String fax, String email, String webHard, String discountType, int discountRate,
                                       String etc) {
        return new CustomCompany(name, type, ceoName, registrationNumber, address,
                telNo, fax, email, webHard, discountType, discountRate, etc);
    }

    public void update(CustomCompany updateInfo) {

    }
}
