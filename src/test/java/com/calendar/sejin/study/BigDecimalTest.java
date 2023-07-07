package com.calendar.sejin.study;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BigDecimalTest {

    @DisplayName("Big Decimal type 에 공백이 들어가는 경우")
    @Test
    void value_is_null() {
        // given
        BigDecimal blankDecimal = new BigDecimal("");

        // when
        String result = blankDecimal.toPlainString();

        // then
        assertThat(result).isNull();
    }
}
