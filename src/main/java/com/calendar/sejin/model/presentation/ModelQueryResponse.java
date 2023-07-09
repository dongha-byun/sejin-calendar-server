package com.calendar.sejin.model.presentation;

import com.calendar.sejin.model.application.ModelDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ModelQueryResponse {

    public static ModelQueryResponse of(ModelDto dto) {
        return new ModelQueryResponse();
    }
}
