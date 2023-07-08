package com.calendar.sejin.study;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BigDecimalTest {

    @DisplayName("Big Decimal type 에 공백이 들어가는 경우, 생성 시점에 예외가 발생한다.")
    @Test
    void value_is_null() {
        // given
        assertThatThrownBy(
                () -> new BigDecimal("")
        );
    }
}
