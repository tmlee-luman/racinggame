package com.lumanlab.racinggame.domain;


import com.lumanlab.racinggame.domain.value.MoveResult;
import com.lumanlab.racinggame.domain.value.RacingResult;
import com.lumanlab.racinggame.utils.MoveValueGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final int EMPTY_RESULT = 0;

    private List<Car> cars;
    private final List<MoveResult> moveResults;

    public RacingCars(List<Car> cars) {
        this(cars, new ArrayList<>());
    }

    private RacingCars(List<Car> cars, List<MoveResult> moveResults) {
        this.cars = new ArrayList<>(cars);
        this.moveResults = moveResults;
    }

    public RacingCars move(int attempts) {
        if (moveResults.size() != EMPTY_RESULT) {
            return new RacingCars(cars).move(attempts);
        }

        for (int i = 0; i < attempts; i++) {
            cars = cars.stream()
                    .map(car -> car.move(MoveValueGenerator.generateMoveValue()))
                    .collect(Collectors.toList());
            moveResults.add(getMoveResults());
        }

        return new RacingCars(cars, moveResults);
    }

    public RacingResult getRacingResult() {
        return new RacingResult(moveResults);
    }

    private MoveResult getMoveResults() {
        return new MoveResult(cars);
    }
}
