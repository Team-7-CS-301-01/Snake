package controller;

import java.awt.event.*;
import model.*;
import view.*;
import javax.swing.Timer;

public class SnakeController implements ActionListener {

    private SnakeModel model;
    private SnakeGUI view;
    private boolean running;
    private char direction = 'R';
    private Timer timer;
    private int DELAY = 1000;

    public void initController(SnakeModel model, SnakeGUI view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        model.initGame();
        view.getGameFrame().addKeyListener(new GameController());
        timer = new Timer(DELAY, this);
        timer.start();
        model.spawnObject();
//        while (running) {
//            Snake s = (Snake) model.getSnake(0);
//            System.out.println(s.getx() + " " + s.gety());
//            System.out.println(s.getDirection());
//            System.out.println("ScoreObject @" + model.getScoreObject(0).getx() + " " + model.getScoreObject(0).gety());
//            System.out.println("Length: " + model.getSnakeLength());
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (running) {
            Snake s = (Snake) model.getSnake(0);
            System.out.println(s.getx() + " " + s.gety());
            System.out.println(s.getDirection());
            System.out.println("ScoreObject @" + model.getScoreObject(0).getx() + " " + model.getScoreObject(0).gety());
            System.out.println("Length: " + model.getSnakeLength());
            s.setDirection(direction);
            model.moveSnake();
            model.checkScoreObject();
            running = model.checkCollision();
        } else if (obj == view.getStart()) {
            //save player name in Player obj in model
            //store till game ends
            //then send that info to database to see if it earns spot

            //call func to update score
            running = true;
            startGame();

            view.drawGamePlayFrame();
        } else if (obj == view.getPause()) {
            //call func to update score
            view.drawPauseFrame();
        } else if (obj == view.getResume()) {
            //call func to update score
            view.drawGamePlayFrame();
        } else if (obj == view.getReturnStart()) {
            view.drawStartFrame();
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
