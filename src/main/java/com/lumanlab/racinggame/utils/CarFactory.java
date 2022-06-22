package com.lumanlab.racinggame.utils;


import com.lumanlab.racinggame.domain.Car;
import com.lumanlab.racinggame.domain.value.Name;
import com.lumanlab.racinggame.domain.value.Position;
import com.lumanlab.racinggame.exception.NotInstanceException;
import com.lumanlab.racinggame.domain.RacingCars;
import com.lumanlab.racinggame.vo.InputValue;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
        throw new NotInstanceException();
    }

    public static RacingCars createRacingCars(InputValue inputValue) {
        return new RacingCars(createCars(inputValue));
    }

    private static List<Car> createCars(InputValue inputValue) {
        return inputValue.carNames()
                .stream()
                .map(name -> new Car(Name.of(name), Position.createInitPosition()))
                .collect(Collectors.toList());
    }
}
