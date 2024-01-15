package draw;

import thread.RectangleThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    private RectangleThread rectangleThread;
    private int startX, startY, endX, endY;

    public DrawingPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (rectangleThread == null || !rectangleThread.isAlive()) {
                    startX = e.getX();
                    startY = e.getY();
                } else {
                    endX = e.getX();
                    endY = e.getY();

                    int speed = 1;
                    String gravityDirection = "Down";

                    startRectangleThread(startX, startY, endX, endY, speed, gravityDirection);
                }
            }
        });

        Timer timer = new Timer(20, e -> {
            if (rectangleThread != null && rectangleThread.isAlive()) {
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (rectangleThread != null && rectangleThread.isAlive()) {
            g.drawRect(rectangleThread.getX1(), rectangleThread.getY1(),
                    rectangleThread.getX2() - rectangleThread.getX1(), rectangleThread.getY2() - rectangleThread.getY1());
        }
    }

    public void startRectangleThread(int x1, int y1, int x2, int y2, int speed, String gravityDirection) {
        if (rectangleThread != null && rectangleThread.isAlive()) {
            rectangleThread.interrupt();
        }
        rectangleThread = new RectangleThread(this, x1, y1, x2, y2, speed, gravityDirection);
        rectangleThread.start();
    }

    public RectangleThread getRectangleThread() {
        return rectangleThread;
    }
}
