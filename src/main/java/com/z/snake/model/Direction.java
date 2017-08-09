package com.z.snake.model;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public enum Direction {

    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    private final int directionCode;

    public int getDirectionCode() {
        return directionCode;
    }

    Direction(int directionCode) {
        this.directionCode = directionCode;
    }

}
