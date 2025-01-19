package software.ulpgc.bouceballsimulator.main;

import software.ulpgc.bouceballsimulator.control.BallController;
import software.ulpgc.bouceballsimulator.model.Ball;
import software.ulpgc.bouceballsimulator.model.BallSimulation;
import software.ulpgc.bouceballsimulator.view.BallView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        BallSimulation simulation = new BallSimulation(900, 200);

        simulation.addBall(Ball.create(20, 0.9), 800.0);
        simulation.addBall(Ball.create(30, 0.8), 600.0);
        simulation.addBall(Ball.create(15, 0.95), 700.0);

        BallView view = new BallView(simulation.getBalls(), simulation.getInitialHeights(), simulation.getPositionsX(), simulation.getGroundLevel());
        new BallController(simulation, view, 9.8);

        JFrame frame = new JFrame("Ball Simulator");
        frame.add(view);
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}