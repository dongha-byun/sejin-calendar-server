package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleCreateDto;
import com.calendar.sejin.rule.application.RuleDto;
import com.calendar.sejin.rule.application.RuleService;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RuleController {
    private final RuleService service;

    @PostMapping("/api/v1/rule")
    public ResponseEntity<RuleResponse> create(RuleCreateRequest createRequest) {
        RuleCreateDto createDto = createRequest.toCreateDto();
        RuleDto ruleDto = service.create(createDto);
        RuleResponse response = RuleResponse.of(ruleDto);

        return ResponseEntity.created(URI.create("/api/v1/rule/"+response.getId())).body(response);
    }
}
