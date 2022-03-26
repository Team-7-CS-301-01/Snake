package model;

import Utility.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Random;

public class SnakeModel implements Subject {

    private ArrayList<GameObject> snake;
    private Timer timer;
    private Random random;
    private ArrayList<ScoreObject> objects;
    private ArrayList<Observer> observers;
    private static final int BOARD_LENGTH = 500;
    private static final int BOARD_WIDTH = 500;
    private static final int UNIT_SIZE = 25;
    private static final int DELAY = 75;
    private static final int GAME_UNITS = (BOARD_WIDTH * BOARD_LENGTH) / UNIT_SIZE;
    private boolean running;
    private int score;

    // game state, menu state, start state, game end state
    public void initGame() {
        random = new Random();
        snake = new ArrayList<GameObject>();
        timer = new Timer();
        objects = new ArrayList<ScoreObject>();
    }

    public void moveSnake() {
        //loop through snake array and move the position to the previous one
        //for the head, need to move it forward in the direction the head is facing
        for (int i = snake.size(); i > 0; i--) {
            snake.get(i).setx(snake.get(i - 1).getx());
            snake.get(i).sety(snake.get(i - 1).gety());
        }
        Snake s = (Snake) snake.get(0);
        switch (s.getDirection()) {
            case 'U':
                snake.get(0).sety(snake.get(0).gety() - UNIT_SIZE);
                break;
            case 'D':
                snake.get(0).sety(snake.get(0).gety() + UNIT_SIZE);
                break;
            case 'L':
                snake.get(0).setx(snake.get(0).getx() - UNIT_SIZE);
                break;
            case 'R':
                snake.get(0).setx(snake.get(0).getx() + UNIT_SIZE);
                break;
        }
    }

    public void addSnake() {
        //loop through and add snake part to snake with position at the end of the tail
        snake.add(new Snake());
    }

    public void spawnObject() {
        //spawn a scoreObject at a random position
        ScoreObject object = new ScoreObject(random.nextInt((int) BOARD_WIDTH / UNIT_SIZE) * UNIT_SIZE, random.nextInt((int) BOARD_LENGTH / UNIT_SIZE) * UNIT_SIZE);
        objects.add(object);
    }

    public void checkCollision() {
        //loops through snake and checks if any have collided with something
        for (int i = snake.size(); i > 0; i--) {
            if ((snake.get(0).getx() == snake.get(i).getx()) && (snake.get(0).gety() == snake.get(i).gety())) {
                running = false;
            }
        }
        //check if head touches left border
        if (snake.get(0).getx() < 0) {
            running = false;
        }
        //check if head touches right border
        if (snake.get(0).getx() > BOARD_WIDTH) {
            running = false;
        }
        //check if head touches top border
        if (snake.get(0).gety() < 0) {
            running = false;
        }
        //check if head touches bottom border
        if (snake.get(0).gety() > BOARD_LENGTH) {
            running = false;
        }

        if (!running) {
            timer.cancel();
        }
    }

    // Checks if snake collides with score object
    public void checkScoreObject() {
        for (int i = 0; i < objects.size(); i++) {
            if ((snake.get(0).getx() == objects.get(i).getx()) && (snake.get(0).gety() == objects.get(i).gety())) {
                addSnake();
                score++;
                objects.remove(i);
                spawnObject();
            }
        }
    }

    public void gameOver() {

    }

    public GameObject getSnake(int x) {
        return snake.get(x);
    }

    public Timer getTimer() {
        return timer;
    }

    public boolean isRunning() {
        return running;
    }

    public ScoreObject getScoreObject(int x) {
        return objects.get(x);
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void detach(Observer o) {
        observers.remove(o);
    }

    public void notifyUpdate(Message m) {
        for (Observer o : observers) {
            o.update(m);
        }
    }
}
