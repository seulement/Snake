package com.z.snake.utils;

import com.z.snake.model.GridPanel;
import com.z.snake.ui.GameView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class GameRunner implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(GameRunner.class);

    private GameView gameView;

    public GameRunner(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info(">>>>>>game runner");
            gameView.getGridPanel().getSnake().move();
            gameView.refresh();
        }
    }

}
