package com.calendar.sejin.menu.application;

import com.calendar.sejin.menu.domain.Menu;
import com.calendar.sejin.menu.domain.MenuQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MenuQueryService {
    private final MenuQueryRepository queryRepository;

    public List<MainMenuQueryDto> findMainMenus() {
        List<Menu> topMenus = queryRepository.findTopMenus();
        return topMenus.stream()
                .map(MainMenuQueryDto::of)
                .toList();
    }

    public List<MenuQueryDto> findTopMenus() {
        List<Menu> topMenus = queryRepository.findTopMenus();
        return topMenus.stream()
                .map(MenuQueryDto::of)
                .toList();
    }
}
