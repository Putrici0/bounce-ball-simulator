package software.ulpgc.bouceballsimulator.model;

import java.util.ArrayList;
import java.util.List;

public class BallSimulation {
    private final List<Ball> balls = new ArrayList<>();
    private final List<Double> initialHeights = new ArrayList<>();
    private final List<Integer> positionsX = new ArrayList<>();
    private final int groundLevel;
    private final int distanceBetweenBalls;

    public BallSimulation(int groundLevel, int distanceBetweenBalls) {
        this.groundLevel = groundLevel;
        this.distanceBetweenBalls = distanceBetweenBalls;
    }

    public void addBall(Ball ball, double initialHeight) {
        balls.add(ball);
        initialHeights.add(initialHeight);
        positionsX.add(100 + (balls.size() - 1) * distanceBetweenBalls);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public List<Double> getInitialHeights() {
        return initialHeights;
    }

    public List<Integer> getPositionsX() {
        return positionsX;
    }

    public int getGroundLevel() {
        return groundLevel;
    }
}