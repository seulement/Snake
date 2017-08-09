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

    public Node eat(Node node) {
        return null;
    }

    public void move() {
        Node temp = null;
        for (int index = 0; index < body.size(); index ++) {
            Node node = body.get(index);
            if (temp == null) {
                logger.info(">>>>head node:" + JSON.toJSONString(getMoveNode(node)));
                body.set(index, getMoveNode(node));
            }else {
                body.set(index, temp);
            }
            temp = new Node(node.getX(), node.getY());
        }
        logger.info(">>>>>body move:" + JSON.toJSONString(body));
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

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void init(int maxWidth, int maxHeight, Graphics g) {

        if (direction == null) {
            direction = Direction.RIGHT;
        }

        int xMax = maxWidth - Constant.DEFAULT_NODE_SIZE;
        int yMax = maxHeight - Constant.DEFAULT_NODE_SIZE;

        Random random = new Random();
        int xPos = random.nextInt(xMax - Constant.DEFAULT_NODE_SIZE * (Constant.DEFAULT_SNAKE_LENGTH + 1)) + Constant.DEFAULT_NODE_SIZE;
        int yPos = random.nextInt(yMax - Constant.DEFAULT_NODE_SIZE * (Constant.DEFAULT_SNAKE_LENGTH + 1)) + Constant.DEFAULT_NODE_SIZE;
        draw(xPos, yPos, g);
        logger.info(">>>>>body init:" + JSON.toJSONString(body));
    }

    public void draw(int x, int y, Graphics g) {
        for (int i = 0; i < Constant.DEFAULT_SNAKE_LENGTH; i ++) {
            int nodeX = x + i * Constant.DEFAULT_NODE_SIZE;
            Node node = new Node(nodeX / Constant.DEFAULT_NODE_SIZE, y / Constant.DEFAULT_NODE_SIZE);
            body.add(node);
            DrawUtil.drawSquare(g, node, Color.BLUE);
        }
    }

    public void refresh(Graphics g) {
        for(Node node : body) {
            node.refresh(g);
        }
    }

    public Node getMoveNode(Node node) {
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
        return new Node(x, y);
    }
}
