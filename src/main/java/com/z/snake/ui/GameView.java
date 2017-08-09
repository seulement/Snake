package com.z.snake.ui;

import com.z.snake.model.GridPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class GameView {

    private JPanel canvas;
    private final GridPanel gridPanel;

    public GameView(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }


    public void init() {
        canvas = new Panel(gridPanel);
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public GridPanel getGridPanel() {
        return gridPanel;
    }

    public void createFood() {
        gridPanel.createFood();
    }

    public void refresh() {
        canvas.validate();
    }

}
