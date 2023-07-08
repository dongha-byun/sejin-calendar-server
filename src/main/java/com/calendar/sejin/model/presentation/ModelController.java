package com.calendar.sejin.model.presentation;

import com.calendar.sejin.model.application.ModelCreateDto;
import com.calendar.sejin.model.application.ModelDto;
import com.calendar.sejin.model.application.ModelService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ModelController {
    private final ModelService modelService;

    @PostMapping("/api/v1/model")
    public ResponseEntity<ModelResponse> create(@Valid @RequestBody ModelCreateRequest createRequest) {
        ModelCreateDto createDto = createRequest.toDto();
        ModelDto modelDto = modelService.create(createDto);
        ModelResponse response = ModelResponse.of(modelDto);

        return ResponseEntity.created(URI.create("/api/v1/model/"+response.getId())).body(response);
    }
}
