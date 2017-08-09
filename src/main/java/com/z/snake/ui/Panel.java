package com.z.snake.ui;

import com.z.snake.model.GridPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class Panel extends JPanel {

    private GridPanel gridPanel;

    public Panel(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gridPanel.init(g);
    }

    @Override
    public void validate() {
        super.validate();
        gridPanel.refresh(getGraphics());
    }
}
