
        
package Utility;

/**
 *
 * @author jmoore
 */
public class Player {
    
    private String name;
    
    private int score;
    
    private int time;
    
    
    Player(String n, int s, int t)
    {
        this.name = n;
        this.score = s;
        this.time = t;
    }

    public Player() {
        this.name = "";
        this.score = 0;
        this.time = 0;
    }

    public void setName(String n) 
    {
        this.name = n;
    }
    public void setScore(int s) 
    {
        this.score = s;
    }
    
    public void setTime(int t) 
    {
        this.time = t;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public int getTime()
    {
        return this.time;
    }
    
    public void resetValues()
    {
        this.setName("");
        this.setScore(0);
        this.setTime(0);
    }    
}
