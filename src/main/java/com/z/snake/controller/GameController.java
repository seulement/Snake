package com.z.snake.controller;

import com.z.snake.model.Direction;
import com.z.snake.model.Snake;
import com.z.snake.ui.GameView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class GameController implements KeyListener {

    private GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
                Snake snake = gameView.getGridPanel().getSnake();
                if (snake.getTurning()) {
                    return;
                }
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        if (snake.getDirection() == Direction.DOWN) {
                            return;
                        }
                        System.out.println("上");
                        snake.setDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        if (snake.getDirection() == Direction.UP) {
                            return;
                        }
                        System.out.println("下");
                        snake.setDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        if (snake.getDirection() == Direction.RIGHT) {
                            return;
                        }
                        System.out.println("左");
                        snake.setDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (snake.getDirection() == Direction.RIGHT) {
                            return;
                        }
                        System.out.println("右");
                        snake.setDirection(Direction.RIGHT);
                break;
                }
                snake.setTurning(true);
    }

    public void keyReleased(KeyEvent e) {

    }


}
