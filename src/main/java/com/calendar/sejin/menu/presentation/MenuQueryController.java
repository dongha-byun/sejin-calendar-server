package com.calendar.sejin.menu.presentation;

import com.calendar.sejin.menu.application.MainMenuQueryDto;
import com.calendar.sejin.menu.application.MenuQueryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MenuQueryController {
    private final MenuQueryService queryService;

    @GetMapping("/mainMenus")
    public ResponseEntity<List<MainMenuResponse>> findMainMenus() {
        List<MainMenuQueryDto> mainMenus = queryService.findMainMenus();
        List<MainMenuResponse> responses = mainMenus.stream()
                .map(MainMenuResponse::of)
                .toList();

        return ResponseEntity.ok().body(responses);
    }
}
