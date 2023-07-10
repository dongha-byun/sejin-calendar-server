package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleCreateDto;
import com.calendar.sejin.rule.application.RuleDto;
import com.calendar.sejin.rule.application.RuleService;
import com.calendar.sejin.rule.application.RuleUpdateDto;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RuleController {
    private final RuleService service;

    @PostMapping("/api/v1/rule")
    public ResponseEntity<RuleResponse> createRule(@Valid @RequestBody RuleCreateRequest createRequest) {
        RuleCreateDto createDto = createRequest.toCreateDto();
        RuleDto ruleDto = service.createRule(createDto);
        RuleResponse response = RuleResponse.of(ruleDto);

        return ResponseEntity.created(URI.create("/api/v1/rule/"+response.getId())).body(response);
    }

    @PutMapping("/api/v1/rule/{id}")
    public ResponseEntity<RuleResponse> updateRuleInfo(@PathVariable("id") Long id,
                                               @RequestBody RuleUpdateRequest updateRequest) {
        RuleUpdateDto updateDto = updateRequest.toDto();
        RuleDto ruleDto = service.changeRuleInfo(id, updateDto);
        RuleResponse response = RuleResponse.of(ruleDto);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/api/v1/rule/{id}")
    public ResponseEntity<RuleResponse> deleteRule(@PathVariable("id") Long id) {
        service.deleteRule(id);
        return ResponseEntity.noContent().build();
    }
}
