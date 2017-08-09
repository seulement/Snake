package com.z.snake.model;

import com.z.snake.utils.DrawUtil;

import java.awt.*;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class Node {

    private final int x;

    private final int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void refresh(Graphics g) {
        DrawUtil.drawSquare(g, this, Color.BLUE);
    }
}
