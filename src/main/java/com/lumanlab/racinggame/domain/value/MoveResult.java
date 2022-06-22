package com.lumanlab.racinggame.domain.value;


import com.lumanlab.racinggame.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MoveResult {
    private static final int NOT_FOUNT_MAX = 0;

    private final List<Car> cars;

    public MoveResult(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> results() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinner() {
        int maxPosition = getMaxPosition();

        return Collections.unmodifiableList(cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList()));
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(NOT_FOUNT_MAX);
    }
}
