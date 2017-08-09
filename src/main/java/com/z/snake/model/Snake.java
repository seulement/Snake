package com.z.snake.model;

import com.z.snake.utils.DrawUtil;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Chenchen.zhang on 2017/8/9 0009.
 */
public class Snake {

    private LinkedList<Node> body = new LinkedList<Node>();

    public Node eat(Node node) {
        return null;
    }

    public Node move(Direction direction) {
        return null;
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node node) {
        this.body.addLast(node);
        return node;
    }

    public LinkedList<Node> getBody() {
        return body;
    }

    public void init(int maxWidth, int maxHeight, Graphics g) {

        int xMax = maxWidth - Constant.DEFAULT_NODE_SIZE;
        int yMax = maxHeight - Constant.DEFAULT_NODE_SIZE;

        Random random = new Random();
        int xPos = random.nextInt(xMax - Constant.DEFAULT_NODE_SIZE) + Constant.DEFAULT_NODE_SIZE;
        int yPos = random.nextInt(yMax - Constant.DEFAULT_NODE_SIZE) + Constant.DEFAULT_NODE_SIZE;
        draw(xPos, yPos, g);
    }

    public void draw(int x, int y, Graphics g) {
        for (int i = 0; i < Constant.DEFAULT_SNAKE_LENGTH; i ++) {
            int nodeX = x + i * Constant.DEFAULT_NODE_SIZE;
            Node node = new Node(nodeX / Constant.DEFAULT_NODE_SIZE, y / Constant.DEFAULT_NODE_SIZE);
            DrawUtil.drawSquare(g, node, Color.BLUE);
        }
    }

}
