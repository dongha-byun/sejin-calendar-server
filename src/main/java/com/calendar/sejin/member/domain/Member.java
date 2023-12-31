package com.calendar.sejin.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "members")
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginId;
    private String password;
    private String name;
    private String address;
    private String telNo;
    private String email;
    private String etc;

    @Builder
    public Member(String loginId, String password, String name, String address, String telNo, String email, String etc) {
        this.loginId = loginId;
        this.password = password;
        this.address = address;
        this.name = name;
        this.telNo = telNo;
        this.email = email;
        this.etc = etc;
    }
}
