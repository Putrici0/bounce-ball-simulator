package software.ulpgc.bouceballsimulator.view;

import software.ulpgc.bouceballsimulator.model.Ball;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BallView extends JPanel {
    private final List<Ball> balls;
    private final List<Double> ballPositionsY;
    private final List<Integer> ballPositionsX;
    private final int groundLevel;

    public BallView(List<Ball> balls, List<Double> initialPositionsY, List<Integer> initialPositionsX, int groundLevel) {
        this.balls = balls;
        this.ballPositionsY = initialPositionsY;
        this.ballPositionsX = initialPositionsX;
        this.groundLevel = groundLevel;
    }

    public void updateBallPositions(List<Double> newPositionsY) {
        for (int i = 0; i < ballPositionsY.size(); i++) {
            ballPositionsY.set(i, newPositionsY.get(i));
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackground(g);
        drawGround(g);
        drawBalls(g);
    }

    private void drawGround(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, groundLevel, getWidth(), groundLevel);
    }

    private void drawBalls(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            int x = ballPositionsX.get(i) - (int) ball.radius(); // Posición X como int
            int y = (int) (ballPositionsY.get(i).doubleValue()); // Posición Y convertida a int
            g.fillOval(x, y, (int) (ball.radius() * 2), (int) (ball.radius() * 2));
        }
    }

    private void drawBackground(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}