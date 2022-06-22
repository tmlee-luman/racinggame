package com.lumanlab.racinggame.controller;

import com.lumanlab.racinggame.domain.value.RacingResult;
import com.lumanlab.racinggame.service.SimpleGameExecutor;
import com.lumanlab.racinggame.utils.GameExecutorFactory;
import com.lumanlab.racinggame.view.ResultView;

public class RacingGameController {

    public void startGame(String carNames, String numberOfAttempts) {
        SimpleGameExecutor gameExecutor = GameExecutorFactory.createGameExecutor(carNames, numberOfAttempts);

        RacingResult result = gameExecutor.execute();

        ResultView resultView = new ResultView(result);
        resultView.showResult();
    }
}
