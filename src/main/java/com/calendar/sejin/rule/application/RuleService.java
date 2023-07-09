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

    public RuleDto create(RuleCreateDto createDto) {
        Rule rule = createDto.toEntity();
        Rule savedRule = repository.save(rule);

        return RuleDto.of(savedRule);
    }
}
