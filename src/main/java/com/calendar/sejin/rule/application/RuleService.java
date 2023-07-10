package com.calendar.sejin.rule.application;

import com.calendar.sejin.rule.domain.Rule;
import com.calendar.sejin.rule.domain.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class RuleService {
    private final RuleRepository repository;

    public RuleDto createRule(RuleCreateDto createDto) {
        Rule rule = createDto.toEntity();
        Rule savedRule = repository.save(rule);

        return RuleDto.of(savedRule);
    }

    public RuleDto changeRuleInfo(Long id, RuleUpdateDto updateDto) {
        Rule rule = repository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("룰 정보 조회 실패")
                );
        rule.changeRuleInfo(updateDto.getName(), updateDto.getEtc());

        return RuleDto.of(rule);
    }

    public void deleteRule(Long id) {
        repository.deleteById(id);
    }
}
