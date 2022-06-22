package com.lumanlab.racinggame.utils;


import com.lumanlab.racinggame.exception.NotInstanceException;

import java.util.Random;

public class MoveValueGenerator {

    private static final Random RANDOM = new Random();
    private static final int MAX = 10;

    private MoveValueGenerator() {
        throw new NotInstanceException();
    }

    public static int generateMoveValue() {
        return RANDOM.nextInt(MAX);
    }
}
