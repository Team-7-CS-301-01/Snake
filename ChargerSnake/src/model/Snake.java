package model;

public class Snake extends GameObject {

    private char direction;

    public Snake() {
        this.setx(250);
        this.sety(250);
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
}
