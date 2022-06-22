package com.lumanlab.racinggame.domain.value;


import com.lumanlab.racinggame.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static com.lumanlab.racinggame.fixture.CarFixture.CAR4;
import static com.lumanlab.racinggame.fixture.CarFixture.CARS;
import static org.assertj.core.api.Assertions.assertThat;


class MoveResultTest {

    @DisplayName("우승자 검증")
    @Test
    void findWinner() {
        MoveResult moveResult = new MoveResult(CARS);

        List<Car> winner = moveResult.findWinner();

        assertThat(winner).containsExactly(CAR4);
    }
}