package com.lumanlab.racinggame.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.lumanlab.racinggame.fixture.PositionFixture.INIT_POSITION;
import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    private Position initPosition = INIT_POSITION;

    @DisplayName("4번 증가시 현재 위치값이 4이어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "4 | 4"
    }, delimiter = '|')
    void increase(int attempts, int expected) {
        for (int i = 0; i < attempts; i++) {
            initPosition.increase();
        }

        assertThat(initPosition.current()).isEqualTo(expected);
    }


}