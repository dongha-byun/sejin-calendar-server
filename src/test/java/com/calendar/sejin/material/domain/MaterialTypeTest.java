package com.calendar.sejin.material.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaterialTypeTest {

    @DisplayName("upper case 변환하여 Enum 조회")
    @Test
    void test() {
        // given
        String str = "twin";
        String pathVariable = "big_paper";

        // when
        String upperStr = str.toUpperCase();
        assertThat(upperStr).isEqualTo("TWIN");

        String upperVariable = pathVariable.toUpperCase();
        assertThat(upperVariable).isEqualTo("BIG_PAPER");

        // then
        MaterialType materialType1 = MaterialType.valueOf(upperStr);
        assertThat(materialType1).isEqualTo(MaterialType.TWIN);

        MaterialType materialType2 = MaterialType.valueOf(upperVariable);
        assertThat(materialType2).isEqualTo(MaterialType.BIG_PAPER);
    }

}