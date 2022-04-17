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
    private final int DELAY = 1000 / 10;


    public void initController(SnakeModel model, SnakeGUI view) {
        this.model = model;
        this.view = view;
        timer = new Timer(DELAY, this);
    }

    public void startGame() {
        model.initGame();
        timer.start();
        timeA = (System.currentTimeMillis() / 1000);
        model.spawnObject();
    }
    
    public void endGame() {
        model.notifyUpdate(new Message("DrawLeaderBoardFrame"));
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
                running = false;
                model.notifyUpdate(new Message("DrawPauseFrame"));
            }
        } else if (obj == view.getStart()) {
            running = true;
            startGame();
            model.notifyUpdate(new Message("DrawGamePlayFrame"));
        } else if (obj == view.getResume()) {
            model.notifyUpdate(new Message("DrawGamePlayFrame"));
            running = true;
        } else if (obj == view.getReturnStart()) {
            game_Over = false;
            model.notifyUpdate(new Message("DrawStartFrame"));
            
        } else if (!running && game_Over) {
            
            timer.stop();
            timeElapsed = (int)((System.currentTimeMillis() / 1000) - timeA);
            model.setTime(timeElapsed);
            model.sendDataToDatabase();
            model.notifyUpdate(new Message("DrawLeaderBoardFrame"));
            model.resetPlayerValues();
            model.notifyUpdate(new Message("ClearName"));
            
        }
        
        model.notifyUpdate(new Message("RePaintGameFrame"));
        
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
