package com.z.snake.utils;

import com.z.snake.model.Constant;
import com.z.snake.model.Node;

import java.awt.*;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class DrawUtil {

    public static void drawSquare(Graphics g, Color color, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public static void drawCircle(Graphics g, Color color, int x, int y, int width, int height) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    public static void drawSquare(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Constant.DEFAULT_NODE_SIZE;
        graphics.fillRect(squareArea.getX() * size, squareArea.getY() * size, size - 1, size - 1);
    }

    public static void drawCircle(Graphics graphics, Node squareArea, Color color) {
        graphics.setColor(color);
        int size = Constant.DEFAULT_NODE_SIZE;
        graphics.fillOval(squareArea.getX() * size, squareArea.getY() * size, size, size);
    }

}
