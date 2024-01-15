package app;

import draw.DrawingPanel;

import javax.swing.*;
//nie działa mi wyświetlanie się na ekranie coś cały czas przeoczałem
public class RectangleDrawingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Rectangle Drawing App");
            frame.setSize(600, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            DrawingPanel drawingPanel = new DrawingPanel();
            frame.add(drawingPanel);
            frame.setLayout(null);
            frame.setVisible(true);
        });
    }
}


