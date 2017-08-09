package com.z.snake.ui;

import com.z.snake.controller.GameController;
import com.z.snake.model.GridPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Chenchen.zhang on 2017/8/9 0009.
 */
public class GameWindow {

    private GameView gameView;

    public GameWindow(GameView gameView) {
        this.gameView = gameView;
    }

    public void createWindow() {

        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        JFrame win = new JFrame("Snake");

        Container container = win.getContentPane();

        gameView.init();

        gameView.getCanvas().setPreferredSize(new Dimension(400, 400));

        container.add(gameView.getCanvas(), BorderLayout.CENTER);

        win.setBounds((width - 400) /2, (height - 400) / 2, 400, 400);

        win.setResizable(false);

        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        win.addKeyListener(new GameController());

        win.pack();

        win.setVisible(true);

    }

}
