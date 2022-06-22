package com.lumanlab.racinggame.utils;

import com.lumanlab.racinggame.exception.NotInstanceException;
import com.lumanlab.racinggame.service.SimpleGameExecutor;

public class GameExecutorFactory {

    private GameExecutorFactory() {
        throw new NotInstanceException();
    }

    public static SimpleGameExecutor createGameExecutor(String carNames, String numberOfAttempts) {
        return new SimpleGameExecutor(InputUtils.convertInputValue(carNames, numberOfAttempts));
    }
}
