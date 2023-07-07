package com.calendar.sejin.model.application;

import com.calendar.sejin.model.domain.Model;
import com.calendar.sejin.model.domain.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelDto create(ModelCreateDto createDto) {
        Model model = createDto.toEntity();
        Model savedModel = modelRepository.save(model);

        return ModelDto.of(savedModel);
    }
}
