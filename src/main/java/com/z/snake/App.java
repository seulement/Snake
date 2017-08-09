package com.z.snake;

import com.z.snake.model.GridPanel;
import com.z.snake.ui.GameView;
import com.z.snake.ui.GameWindow;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class App {

    public static void main(String... args){
        GameWindow window = new GameWindow(new GameView(new GridPanel(400, 400)));
        window.createWindow();
    }

}
