package controller;

import java.awt.event.*;
import model.*;
import view.*;
import java.lang.Package;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Timer;

public class SnakeController {

    private SnakeModel model;
    private SnakeFrame view;
    private boolean running = true;
    private char direction = 'R';
    private Timer timer;
    private int DELAY = 1000 / 60;

    public SnakeController(SnakeModel model, SnakeFrame view) {
        this.model = model;
        this.view = view;
        startGame();
    }

    public void startGame() {
        model.initGame();
        view.addKeyListener(new GameController());
        while (running) {
            Snake s = (Snake) model.getSnake(0);
            s.setDirection(direction);
            model.moveSnake();
            model.checkScoreObject();
            running = model.checkCollision();
            System.out.println(s.getx() + " " + s.gety());
            System.out.println(s.getDirection());
            System.out.println("working");

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
