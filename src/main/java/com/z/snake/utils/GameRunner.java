package com.z.snake.utils;

import com.z.snake.model.GridPanel;
import com.z.snake.ui.GameView;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class GameRunner implements Runnable {

    private GameView gameView;

    public GameRunner(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameView.createFood();
        gameView.refresh();
    }

}
