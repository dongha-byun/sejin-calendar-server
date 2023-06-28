package com.calendar.sejin.material.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "materials")
@Entity
public class Material {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private MaterialType type;

    private String standard1;
    private String standard2;

    private String content;
    private String color;

    @Builder
    public Material(MaterialType type, String standard1, String standard2, String content, String color) {
        this.type = type;
        this.standard1 = standard1;
        this.standard2 = standard2;
        this.content = content;
        this.color = color;
    }

    public static Material create(MaterialType type, String standard1, String standard2, String content, String color) {
        return Material.builder()
                .type(type)
                .standard1(standard1)
                .standard2(standard2)
                .content(content)
                .color(color)
                .build();
    }

    public void update(Material updateEntity) {
        this.type = updateEntity.getType();
        this.standard1 = updateEntity.getStandard1();
        this.standard2 = updateEntity.getStandard2();
        this.content = updateEntity.getContent();
        this.color = updateEntity.getColor();
    }
}
