package com.calendar.sejin.paper.presentation;

import com.calendar.sejin.paper.application.PaperDto;
import com.calendar.sejin.paper.application.PaperQueryService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PaperQueryController {
    private final PaperQueryService paperQueryService;

    @GetMapping("/api/v1/papers")
    public ResponseEntity<PaperQueryResponse> findPaperAll() {
        List<PaperDto> paperDtoAll = paperQueryService.findPaperDtoAll();
        List<PaperResponse> responses = paperDtoAll.stream()
                .map(PaperResponse::of)
                .toList();

        return ResponseEntity.ok().body(
                new PaperQueryResponse(responses)
        );
    }
}
