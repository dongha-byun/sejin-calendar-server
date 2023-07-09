package com.calendar.sejin.customcompany.presentation;

import com.calendar.sejin.api.ErrorResponse;
import com.calendar.sejin.customcompany.application.CustomCompanyCreateDto;
import com.calendar.sejin.customcompany.application.CustomCompanyDto;
import com.calendar.sejin.customcompany.application.CustomCompanyService;
import com.calendar.sejin.customcompany.application.CustomCompanyUpdateDto;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustomCompanyController {
    private final CustomCompanyService customCompanyService;

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> nullPointerException(NullPointerException e) {
        return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
    }

    @PostMapping("/api/v1/custom-company")
    public ResponseEntity<CustomCompanyResponse> create(@Valid @RequestBody CustomCompanyCreateRequest createRequest) {
        CustomCompanyCreateDto createDto = createRequest.toCreateDto();
        CustomCompanyDto customCompanyDto = customCompanyService.create(createDto);
        CustomCompanyResponse response = CustomCompanyResponse.of(customCompanyDto);

        return ResponseEntity.created(URI.create("/api/v1/custom-company/"+response.getId())).body(response);
    }

    @PutMapping("/api/v1/custom-company/{id}")
    public ResponseEntity<CustomCompanyResponse> update(@PathVariable("id") Long id,
                                                        @RequestBody CustomCompanyUpdateRequest updateRequest) {
        CustomCompanyUpdateDto updateDto = updateRequest.toUpdateDto();
        CustomCompanyDto customCompanyDto = customCompanyService.update(id, updateDto);
        CustomCompanyResponse response = CustomCompanyResponse.of(customCompanyDto);

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/api/v1/custom-company/{id}")
    public ResponseEntity<CustomCompanyResponse> delete(@PathVariable("id") Long id) {
        customCompanyService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
