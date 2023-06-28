package com.calendar.sejin.material.presentation;

import com.calendar.sejin.material.application.MaterialCreateDto;
import com.calendar.sejin.material.application.MaterialDto;
import com.calendar.sejin.material.application.MaterialService;
import com.calendar.sejin.material.application.MaterialUpdateDto;
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
public class MaterialController {
    private final MaterialService materialService;

    @PostMapping("/api/v1/material")
    public ResponseEntity<MaterialResponse> create(@RequestBody MaterialCreateRequest createRequest) {
        MaterialCreateDto materialCreateDto = createRequest.toCreateDto();
        MaterialDto materialDto = materialService.create(materialCreateDto);
        MaterialResponse response = MaterialResponse.of(materialDto);

        return ResponseEntity.created(URI.create("/api/v1/material/"+response.getId())).body(response);
    }
    
    @PutMapping("/api/v1/material/{id}")
    public ResponseEntity<MaterialResponse> update(@PathVariable("id") Long id,
                                                   @RequestBody MaterialUpdateRequest updateRequest) {
        MaterialUpdateDto updateDto = updateRequest.toUpdateDto();
        MaterialDto materialDto = materialService.update(id, updateDto);
        MaterialResponse response = MaterialResponse.of(materialDto);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/api/v1/material/{id}")
    public ResponseEntity<MaterialResponse> delete(@PathVariable("id") Long id) {
        materialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
