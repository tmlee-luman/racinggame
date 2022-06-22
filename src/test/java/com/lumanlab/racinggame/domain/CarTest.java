package com.lumanlab.racinggame.domain;

import com.lumanlab.racinggame.domain.value.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.lumanlab.racinggame.fixture.CarFixture.CAR1;
import static com.lumanlab.racinggame.fixture.CarFixture.CAR5;
import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @DisplayName("moveValue에 따른 자동차 전진상태 확인")
    @ParameterizedTest
    @MethodSource("provideMoveValue")
    void move(int moveValue1, int moveValue2, int moveValue3, int expected) {
        CAR5.move(moveValue1);
        CAR5.move(moveValue2);
        CAR5.move(moveValue3);

        Position position = Position.of(expected);
        assertThat(CAR5.position()).isEqualTo(position.current());
    }

    private static Stream<Arguments> provideMoveValue() {
        return Stream.of(
                Arguments.of(2, 5, 7, 2));
    }
}