package com.z.snake.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Administrator on 2017/8/9 0009.
 */
public class GameController implements KeyListener {


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                System.out.println("上");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("下");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("左");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("右");
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }


}
