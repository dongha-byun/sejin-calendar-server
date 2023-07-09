package com.calendar.sejin.model.application;

import com.calendar.sejin.model.domain.Model;
import com.calendar.sejin.model.domain.ModelQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ModelQueryService {
    private final ModelQueryRepository queryRepository;

    public List<ModelDto> findModelAll() {
        List<Model> models = queryRepository.findModelAll();
        return models.stream()
                .map(ModelDto::of)
                .toList();
    }
}
