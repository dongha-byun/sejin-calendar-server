package com.calendar.sejin.paper.presentation;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaperQueryResponse {
    private List<PaperResponse> data;
    private List<String> paperKinds;
    private List<String> standards;
}
