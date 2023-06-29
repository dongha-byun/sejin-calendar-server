package com.calendar.sejin.paper.application;

import com.calendar.sejin.paper.domain.Paper;
import com.calendar.sejin.paper.domain.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PaperService {
    private final PaperRepository paperRepository;

    public PaperDto create(PaperCreateDto createDto) {
        Paper paper = createDto.toEntity();
        Paper savedPaper = paperRepository.save(paper);

        return PaperDto.of(savedPaper);
    }

    public PaperDto update(Long id, PaperUpdateDto updateDto) {
        Paper findPaper = paperRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("용지 정보 조회 실패")
                );
        Paper updateInfo = updateDto.toEntity();

        findPaper.update(updateInfo);

        return PaperDto.of(findPaper);
    }

    public void delete(Long id) {
        Paper findPaper = paperRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("용지 정보 조회 실패")
                );
        paperRepository.delete(findPaper);
    }
}
