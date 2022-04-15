
        
package Utility;

/**
 *
 * @author jmoore
 */
public class Player {
    
    private final String name;
    
    private final String score;
    
    private final String time;
    
    
    Player(String n, String s, String t)
    {
        this.name = n;
        this.score = s;
        this.time = t;
    }

    public Player() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
