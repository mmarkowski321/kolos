package thread;

import javax.swing.*;
import java.awt.*;

public class RectangleThread extends Thread {
    private final JPanel panel;
    private int x1, y1, x2, y2;
    private int speed;
    private String gravityDirection;

    public RectangleThread(JPanel panel, int x1, int y1, int x2, int y2, int speed, String gravityDirection) {
        this.panel = panel;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.speed = speed;
        this.gravityDirection = gravityDirection;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            moveRectangle();
            try {
                sleep(20);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    private void moveRectangle() {
        switch (gravityDirection) {
            case "Down":
                y1 += speed;
                y2 += speed;
                break;
            case "Up":
                y1 -= speed;
                y2 -= speed;
                break;
            case "Right":
                x1 += speed;
                x2 += speed;
                break;
            case "Left":
                x1 -= speed;
                x2 -= speed;
                break;
        }

        if (y1 > panel.getHeight() || y2 > panel.getHeight()) {
            y1 = 0;
            y2 = y1 + Math.abs(y2 - y1);
        }

        if (x1 > panel.getWidth() || x2 > panel.getWidth()) {
            x1 = 0;
            x2 = x1 + Math.abs(x2 - x1);
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }
}
