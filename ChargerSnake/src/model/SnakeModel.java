package model;

import Utility.*;
import java.util.ArrayList;
import java.util.Random;

public class SnakeModel implements Subject {

    private ArrayList<GameObject> snake;
    private Random random;
    private ArrayList<ScoreObject> objects;
    private ArrayList<Observer> observers;
    private static final int BOARD_LENGTH = 500;
    private static final int BOARD_WIDTH = 500;
    private static final int UNIT_SIZE = 25;
    private static final int GAME_UNITS = (BOARD_WIDTH * BOARD_LENGTH) / UNIT_SIZE;
    private boolean running;
    private int score;

    // game state, menu state, start state, game end state
    public void initGame() {
        random = new Random();
        snake = new ArrayList<GameObject>();
        objects = new ArrayList<ScoreObject>();
        snake.add(new Snake());
        for (int i = 0; i < 5; i++) {
            snake.add(new GameObject());
        }
    }

    public void gameOver() {

    }

    public void pauseMenu() {

    }

    public void startMenu() {

    }

    public void moveSnake() {
        //loop through snake array and move the position to the previous one
        //for the head, need to move it forward in the direction the head is facing
        for (int i = snake.size() - 1; i > 0; i--) {
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

    public boolean checkCollision() {
        //loops through snake and checks if any have collided with something
        for (int i = snake.size() - 1; i > 0; i--) {
            if ((snake.get(0).getx() == snake.get(i).getx()) && (snake.get(0).gety() == snake.get(i).gety())) {
                return false;
            }
        }
        //check if head touches left border
        if (snake.get(0).getx() < 0) {
            return false;
        }
        //check if head touches right border
        if (snake.get(0).getx() > BOARD_WIDTH) {
            return false;
        }
        //check if head touches top border
        if (snake.get(0).gety() < 0) {
            return false;
        }
        //check if head touches bottom border
        if (snake.get(0).gety() > BOARD_LENGTH) {
            return false;
        }
        return true;
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

    public GameObject getSnake(int x) {
        return snake.get(x);
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

    public int getBOARD_LENGTH() {
        return BOARD_LENGTH;
    }

    public int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    public int getUNIT_SIZE() {
        return UNIT_SIZE;
    }

    public int getGAME_UNITS() {
        return GAME_UNITS;
    }

    public int getSnakeLength() {
        return snake.size();
    }
}
