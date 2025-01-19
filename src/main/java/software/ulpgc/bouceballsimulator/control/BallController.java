package software.ulpgc.bouceballsimulator.control;

import software.ulpgc.bouceballsimulator.model.BallSimulation;
import software.ulpgc.bouceballsimulator.view.BallView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BallController {
    private final BallSimulation simulation;
    private final BallView view;
    private final double gravity;
    private final List<Double> velocities = new ArrayList<>();
    private final List<Double> ballPositionsY = new ArrayList<>();
    private final int groundLevel;

    public BallController(BallSimulation simulation, BallView view, double gravity) {
        this.simulation = simulation;
        this.view = view;
        this.gravity = gravity;
        this.groundLevel = simulation.getGroundLevel();

        initializeSimulation();

        Timer timer = new Timer(1, e -> updateSimulation());
        timer.start();
    }

    private void initializeSimulation() {
        for (double height : simulation.getInitialHeights()) {
            ballPositionsY.add(groundLevel - height);
            velocities.add(0.0);
        }
    }

    private void updateSimulation() {
        for (int i = 0; i < simulation.getBalls().size(); i++) {
            updateVelocity(i);
            updateBallPosition(i);
            if (isBallOnGround(i)) {
                handleGroundCollision(i);
            }
        }
        view.updateBallPositions(ballPositionsY);
    }

    private void updateVelocity(int index) {
        velocities.set(index, velocities.get(index) + gravity * 0.016);
    }

    private void updateBallPosition(int index) {
        ballPositionsY.set(index, ballPositionsY.get(index) + velocities.get(index));
    }

    private boolean isBallOnGround(int index) {
        return ballPositionsY.get(index) >= groundLevel - simulation.getBalls().get(index).radius() * 2;
    }

    private void handleGroundCollision(int index) {
        ballPositionsY.set(index, groundLevel - simulation.getBalls().get(index).radius() * 2);
        velocities.set(index, -velocities.get(index) * simulation.getBalls().get(index).restitution());
    }
}