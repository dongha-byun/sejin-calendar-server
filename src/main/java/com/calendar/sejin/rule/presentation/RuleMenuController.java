package com.calendar.sejin.rule.presentation;

import com.calendar.sejin.rule.application.RuleMenuDto;
import com.calendar.sejin.rule.application.RuleMenuInsertDto;
import com.calendar.sejin.rule.application.RuleMenuService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RuleMenuController {
    private final RuleMenuService ruleMenuService;

    @PostMapping("/api/v1/rule/{ruleId}/menus")
    public ResponseEntity<List<RuleMenuResponse>> addMenuOfRule(@PathVariable("ruleId") Long ruleId,
                                                                @RequestBody RuleMenuInsertRequest ruleMenuInsertRequest) {
        List<RuleMenuInsertDto> ruleMenuInsertDtos = ruleMenuInsertRequest.toDtoList();
        List<RuleMenuDto> ruleMenuDtos = ruleMenuService.addMenuOfRule(ruleId, ruleMenuInsertDtos);
        List<RuleMenuResponse> ruleMenuResponses = ruleMenuDtos.stream()
                .map(RuleMenuResponse::of)
                .toList();

        return ResponseEntity.ok().body(ruleMenuResponses);
    }
}
