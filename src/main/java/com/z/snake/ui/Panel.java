package com.z.snake.ui;

import com.z.snake.model.GridPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class Panel extends JPanel {

    private static Logger logger = LoggerFactory.getLogger(Panel.class);

    private GridPanel gridPanel;

    public Panel(GridPanel gridPanel) {
        this.gridPanel = gridPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gridPanel.getSnake() == null)
        gridPanel.init(g);
        logger.info(">>>>>>>gridPanel.init()");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    public void validate() {
        paint(getGraphics());
        gridPanel.refresh(getGraphics());
    }
}
