package model;

public class Snake {

    private int x, y;
    String name;
    int score;
    int dx, dy;
    boolean isColliding;
    
    
    public Snake()
    {
        this.x = 0;
        this.y = 0;
        this.name = "";
        this.score = 0;
        this.dx = 0;
        this.dy = 0;
        this.isColliding = false;
    }
    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getdx() {
        return dx;
    }

    public int getdy() {
        return dy;
    }

    public boolean getColliding() {
        return isColliding;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
    }

}
