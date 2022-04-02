
        
package Utility;

/**
 *
 * @author jmoore
 */
public class Player {
    
    private String name;
    
    private String score;
    
    private String time;
    
    
    Player(String n, String s, String t)
    {
        this.name = n;
        this.score = s;
        this.time = t;
    }
        
    public String getName()
    {
        return this.name;
    }
    
    public String getScore()
    {
        return this.score;
    }
    
    public String getTime()
    {
        return this.time;
    }
    
}
