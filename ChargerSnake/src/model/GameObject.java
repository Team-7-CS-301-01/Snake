package model;

import Utility.*;

public class GameObject implements Observer {

    private int x, y;

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public void update(Message m) {
    }
}
