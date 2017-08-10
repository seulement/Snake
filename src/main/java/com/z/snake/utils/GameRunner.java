package com.z.snake.utils;

import com.z.snake.model.Direction;
import com.z.snake.model.GridPanel;
import com.z.snake.model.Node;
import com.z.snake.model.Snake;
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
        int i = 0;
        boolean notOver = true;
        while(notOver) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Snake snake = gameView.getGridPanel().getSnake();
            Node food = gameView.getGridPanel().getFood();
            Node nextNode = snake.getMoveNode();
            if (nextNode.getX() == food.getX() && nextNode.getY() == food.getY()){
                snake.eat(nextNode);
                gameView.getGridPanel().createFood();
            } else {
                gameView.getGridPanel().getSnake().move(nextNode);
            }
            gameView.getGridPanel().getSnake().setTurning(false);
            if (!gameView.getGridPanel().getSnake().check(gameView.getGridPanel().getWidth(), gameView.getGridPanel().getHeight())) {
                break;
            }
            gameView.refresh();
        }
        logger.info(">>>>>>GAME OVER !!!!!!");
    }

}
