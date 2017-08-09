package com.z.snake.model;

import com.z.snake.utils.DrawUtil;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Chenchen.zhang on 2017/8/9 0009.
 */
public class GridPanel {

    private Snake snake;

    private final int width;

    private final int height;

    private Node food;

    public GridPanel(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init(Graphics g) {
        drawBackground(g, Color.BLACK, 0, 0, width, height);
        snake = new Snake();
        snake.init(width, height, g);
    }

    private void drawBackground(Graphics g, Color color, int x, int y, int width, int height) {
        DrawUtil.drawSquare(g, color, x, y, width, height);
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Node getFood() {
        return food;
    }

    public void setFood(Node food) {
        this.food = food;
    }

    public void createFood() {
        Random random = new Random();
        boolean flag = true;
        while (flag) {
            boolean hasSame = false;
            Node node = new Node(random.nextInt(width - Constant.DEFAULT_NODE_SIZE) / Constant.DEFAULT_NODE_SIZE,
                    random.nextInt(height - Constant.DEFAULT_NODE_SIZE) / Constant.DEFAULT_NODE_SIZE);
            LinkedList<Node> nodes = snake.getBody();
            for (Node b : nodes) {
                if (b.getX() == node.getX() && b.getY() == node.getY()) {
                    hasSame = true;
                }
            }
            if (!hasSame) {
                food = node;
            }
        }
    }

    public void refresh(Graphics g) {

    }
}
