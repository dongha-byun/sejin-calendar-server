package com.calendar.sejin.paper.presentation;

import com.calendar.sejin.paper.application.PaperCreateDto;
import com.calendar.sejin.paper.application.PaperDto;
import com.calendar.sejin.paper.application.PaperService;
import com.calendar.sejin.paper.application.PaperUpdateDto;
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
public class PaperController {
    private final PaperService paperService;

    @PostMapping("/api/v1/paper")
    public ResponseEntity<PaperResponse> create(@RequestBody PaperCreateRequest createRequest) {
        PaperCreateDto paperCreateDto = createRequest.toCreateDto();
        PaperDto paperDto = paperService.create(paperCreateDto);
        PaperResponse response = PaperResponse.of(paperDto);

        return ResponseEntity.created(URI.create("/api/v1/paper/"+response.getId())).body(response);
    }

    @PutMapping("/api/v1/paper/{id}")
    public ResponseEntity<PaperResponse> update(@PathVariable("id") Long id,
                                                @RequestBody PaperUpdateRequest updateRequest) {
        PaperUpdateDto paperUpdateDto = updateRequest.toUpdateDto();
        PaperDto paperDto = paperService.update(id, paperUpdateDto);
        PaperResponse response = PaperResponse.of(paperDto);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/api/v1/paper/{id}")
    public ResponseEntity<PaperResponse> delete(@PathVariable("id") Long id) {
        paperService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
