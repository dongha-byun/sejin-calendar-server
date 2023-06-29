package com.calendar.sejin.paper.application;

import com.calendar.sejin.paper.domain.PaperQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PaperQueryService {
    private final PaperQueryRepository paperQueryRepository;

    public List<PaperDto> findPaperDtoAll() {
        return paperQueryRepository.findPaperDtoAll();
    }
}
