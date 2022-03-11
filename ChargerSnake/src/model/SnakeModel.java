package model;

import Utility.Message;
import Utility.Observer;
import Utility.Subject;
import java.util.ArrayList;

public class SnakeModel implements ModelInterface, Subject {

    private Snake snake;
    private GameTimer timer;
    private ArrayList<ScoreObject> objects;
    private ArrayList<Observer> observers;

    public SnakeModel(Snake snake, GameTimer timer, ArrayList<ScoreObject> objects) {
        this.snake = snake;
        this.timer = timer;
        this.objects = objects;
    }

    public SnakeModel() {

    }

    public Snake getSnake() {
        return snake;
    }

    public GameTimer getTimer() {
        return timer;
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
