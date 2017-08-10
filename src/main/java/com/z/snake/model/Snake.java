package com.z.snake.model;

import com.alibaba.fastjson.JSON;
import com.z.snake.utils.DrawUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Chenchen.zhang on 2017/8/9 0009.
 */
public class Snake {

    private static Logger logger = LoggerFactory.getLogger(Snake.class);

    private LinkedList<Node> body = new LinkedList<Node>();

    private Direction direction;

    private boolean turning = false;

    public void eat(Node node) {
        body.add(node);
    }

    public void move(Node nextNode) {
        body.add(nextNode);
        body.remove(0);
    }

    public Node getHead() {
        return body.getFirst();
    }

    public Node addTail(Node node) {
        this.body.addLast(node);
        return node;
    }

    public void setTurning(boolean turning) {
        this.turning = turning;
    }

    public boolean getTurning() {
        return turning;
    }

    public LinkedList<Node> getBody() {
        return body;
    }


    public Direction getDirection() {
        return direction;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void init(int maxWidth, int maxHeight) {

        if (direction == null) {
            direction = Direction.RIGHT;
        }

        int xMax = maxWidth - Constant.DEFAULT_NODE_SIZE;
        int yMax = maxHeight - Constant.DEFAULT_NODE_SIZE;

        Random random = new Random();
        int xPos = random.nextInt(xMax - Constant.DEFAULT_NODE_SIZE * (Constant.DEFAULT_SNAKE_LENGTH + 1)) + Constant.DEFAULT_NODE_SIZE;
        int yPos = random.nextInt(yMax - Constant.DEFAULT_NODE_SIZE * (Constant.DEFAULT_SNAKE_LENGTH + 1)) + Constant.DEFAULT_NODE_SIZE;
        createSnake(xPos, yPos);
        logger.info(">>>>>body init:" + JSON.toJSONString(body));
    }

    public void createSnake(int x, int y) {
        for (int i = 0; i < Constant.DEFAULT_SNAKE_LENGTH; i ++) {
            int nodeX = x + i * Constant.DEFAULT_NODE_SIZE;
            Node node = new Node(nodeX / Constant.DEFAULT_NODE_SIZE, y / Constant.DEFAULT_NODE_SIZE);
            body.add(node);
        }
    }

    public void refresh(Graphics g) {
        for(Node node : body) {
            node.refresh(g);
        }
    }

    public Node getMoveNode() {
        Node node = body.getLast();
        int x = node.getX();
        int y = node.getY();
        switch (direction) {
            case UP:
                y = y - 1;
                break;
            case DOWN:
                y = y + 1;
                break;
            case LEFT:
                x = x - 1;
                break;
            case RIGHT:
                x = x + 1;
                break;
        }
        Node nextNode = new Node(x, y);
        return nextNode;
    }

    public boolean check(int width, int height) {
        Node node = body.getLast();
        if (node.getX() < 0 || node.getX() >= width / Constant.DEFAULT_NODE_SIZE
                || node.getY() < 0 || node.getY() >= height / Constant.DEFAULT_NODE_SIZE) {
            return false;
        }
        for (Node bNode : body) {
            if (bNode == node) {
                continue;
            }
            if (bNode.getX() == node.getX() && bNode.getY() == node.getY()) {
                return false;
            }
        }
        return true;
    }
}
