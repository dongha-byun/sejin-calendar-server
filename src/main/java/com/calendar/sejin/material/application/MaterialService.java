package com.calendar.sejin.material.application;

import com.calendar.sejin.material.domain.Material;
import com.calendar.sejin.material.domain.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialDto create(MaterialCreateDto createDto) {
        Material material = createDto.toEntity();
        Material savedMaterial = materialRepository.save(material);

        return MaterialDto.of(savedMaterial);
    }

    public MaterialDto update(Long id, MaterialUpdateDto updateDto) {
        Material updateEntity = updateDto.toEntity();
        Material material = materialRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("원자재 조회 실패")
                );
        material.update(updateEntity);

        return MaterialDto.of(material);
    }

    public void delete(Long id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("원자재 조회 실패")
                );
        materialRepository.delete(material);
    }
}
