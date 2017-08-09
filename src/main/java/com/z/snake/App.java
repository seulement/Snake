package com.z.snake;

import com.z.snake.model.GridPanel;
import com.z.snake.ui.GameView;
import com.z.snake.ui.GameWindow;
import com.z.snake.utils.GameRunner;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class App {

    public static void main(String... args){
        GameView gameView = new GameView(new GridPanel(400, 400));
        GameWindow window = new GameWindow(gameView);
        window.createWindow();
        new Thread(new GameRunner(gameView)).start();
    }

}
