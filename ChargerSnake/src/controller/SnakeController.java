package controller;

import java.awt.event.*;
import model.*;
import view.*;
import javax.swing.Timer;

public class SnakeController implements ActionListener {

    private SnakeModel model;
    private SnakeFrame view;
    private boolean running = true;
    private char direction = 'R';
    private Timer timer;
    private int DELAY = 1000;

    public SnakeController(SnakeModel model, SnakeFrame view) {
        this.model = model;
        this.view = view;
        startGame();
    }

    public void startGame() {
        model.initGame();
        view.addKeyListener(new GameController());
        timer = new Timer(DELAY, this);
        timer.start();
        model.spawnObject();
        while (running) {
            Snake s = (Snake) model.getSnake(0);
            System.out.println(s.getx() + " " + s.gety());
            System.out.println(s.getDirection());
            System.out.println("ScoreObject @" + model.getScoreObject(0).getx() + " " + model.getScoreObject(0).gety());
            System.out.println("Length: " + model.getSnakeLength());
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (running) {
            Snake s = (Snake) model.getSnake(0);
            s.setDirection(direction);
            model.moveSnake();
            model.checkScoreObject();
            running = model.checkCollision();
        }
    }

    public class GameController extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
        }
    }

}
