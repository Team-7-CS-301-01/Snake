package controller;

import Utility.*;
import java.awt.event.*;
import model.*;
import view.*;
import javax.swing.Timer;

public class SnakeController implements ActionListener {

    private SnakeModel model;
    private SnakeGUI view;
    private boolean running;
    private boolean game_Over = false;
    private char direction = 'R';
    private Timer timer;
    private long timeA;
    private int timeElapsed;
    private int score;
    private String name;
    private final int DELAY = 1000 / 10;

    public void initController(SnakeModel model, SnakeGUI view) {
        this.model = model;
        this.view = view;
        timer = new Timer(DELAY, this);
        this.view.getGameFrame().addKeyListener(new GameController());
    }

    public void startGame() {
        model.initGame();
        model.attach(view);
        timer.start();
        timeA = (System.currentTimeMillis() / 1000);
        model.spawnObject();
    }

    public void endGame() {
        view.drawLeaderBoardFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (running) {
            Snake s = (Snake) model.getSnake(0);
            s.setDirection(direction);
            model.moveSnake();
            model.checkScoreObject();
            running = model.checkCollision();
            model.notifyUpdate(new Message("UpdateScore"));
            if (running == false) {
                game_Over = true;
            }
            if (obj == view.getPause()) {
                //call func to update score
                running = false;
                view.drawPauseFrame();
            }
        } else if (obj == view.getStart()) {
            //save player name in Player obj in model
            //store till game ends
            //then send that info to database to see if it earns spot

            //call func to update score
            running = true;
            startGame();

            view.drawGamePlayFrame();
        } else if (obj == view.getResume()) {
            //call func to update score
            view.drawGamePlayFrame();
            running = true;
        } else if (obj == view.getReturnStart()) {
            game_Over = false;
            view.drawStartFrame();
        } else if (!running && game_Over) {

            timer.stop();
            timeElapsed = (int) ((System.currentTimeMillis() / 1000) - timeA);
            score = model.getScore();
            name = view.getName();
            model.sendData(name, score, timeElapsed);
            view.drawLeaderBoardFrame();
            model.detach(view);
        }
        view.getGameFrame().repaint();
    }

    public class GameController extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            if (running) {
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

}
