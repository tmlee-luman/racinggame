package com.lumanlab.racinggame.service;

import com.lumanlab.racinggame.domain.value.RacingResult;
import com.lumanlab.racinggame.utils.CarFactory;
import com.lumanlab.racinggame.vo.InputValue;

public class SimpleGameExecutor {

    private final InputValue inputValue;

    public SimpleGameExecutor(InputValue inputValue) {
        this.inputValue = inputValue;
    }

    public RacingResult execute() {
        RacingCars racingCars = CarFactory.createRacingCars(inputValue);
        return racingCars.move(inputValue.attempts())
                .getRacingResult();

    }


}
