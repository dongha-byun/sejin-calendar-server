package com.calendar.sejin.model.presentation;

import com.calendar.sejin.model.application.ModelDto;
import com.calendar.sejin.model.application.ModelQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ModelQueryController {
    private final ModelQueryService queryService;

    @GetMapping("/api/v1/models")
    public ResponseEntity<List<ModelQueryResponse>> findModels() {
        List<ModelDto> models = queryService.findModelAll();
        List<ModelQueryResponse> responses = models.stream()
                .map(ModelQueryResponse::of)
                .toList();

        return ResponseEntity.ok().body(responses);
    }
}
