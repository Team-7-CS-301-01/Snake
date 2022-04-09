package Utility;
import java.sql.*;
import java.util.ArrayList;
 

public class Database 
{
 
    private final String URL;
    private final Connection conn;
    private final Statement statement;
    private String query;
    private ResultSet result;
    

    
    public Database() throws SQLException
    {
        
        
        URL = "jdbc:derby:LeaderBoard;create=true";
        
        conn = DriverManager.getConnection(URL);
        
        statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                        ResultSet.CONCUR_UPDATABLE);  
        
        query = "";
        
        
        if (!doesTableExists("LeaderBoard")) {
               
             	initLeaderBoard();
                
        }
        
    }
    
    
    
    public void disconnectFromLeaderBoard() 
    {

        try
        {
            if (statement != null)
            {
                statement.close();
            }
            if (conn != null)
            {
                DriverManager.getConnection(URL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            
        }
        
    }    
    
    
    
    public void deleteLeaderBoard() throws SQLException
    {
                  
        query = "DROP TABLE LeaderBoard";
        
        statement.execute(query);        
        
        
    }
    
    
    
    public void insertLeaderBoard(String name, int score, int time) throws SQLException
    {
                      
            
            result = statement.executeQuery("SELECT * FROM LeaderBoard ORDER BY Score DESC");
             
            result.absolute(10); // compare against the 10th row
            
            int lastPlaceScore = result.getInt("Score");
            
            int rowId = result.getInt("Id");
            
         
            if(score > lastPlaceScore)
            {
                
                query = "UPDATE LeaderBoard SET Name= '" + name + "', Score= " + score + ", Time= " + time  + " WHERE Id=" + rowId + "";

                statement.execute(query);
                
            }
            
            
    }
    

    
    private void initLeaderBoard() throws SQLException
    {
        
                
            query = "CREATE TABLE LeaderBoard("
            + "Id INT NOT NULL GENERATED ALWAYS AS IDENTITY, "
            + "Name varchar(128), "
            + "Score int, "
            + "Time int)";


            statement.execute(query);        



            //insert 10 unknown values

            query = "INSERT INTO LeaderBoard ("
                    + "Name, Score, Time) VALUES ("
                    + "'Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0), "
                    + "('Unknown', 0, 0)";

            statement.execute(query);        
                
    }
   
    
        
    
    public ArrayList<Player> getLeaderBoard() throws SQLException
    {
        
            ArrayList<Player> playerList = new ArrayList<>(10);           
            
            query = "SELECT * FROM LeaderBoard ORDER BY Score DESC";
        
            result = statement.executeQuery(query);        
        
            while (result.next()) {
                
                playerList.add(new Player(result.getString("Name"), result.getString("Score"), result.getString("Time")));
                
            }    
            
            return playerList;
            
    }
    
    
    
    private boolean doesTableExists(String tableName) throws SQLException
    {
        
            DatabaseMetaData meta = conn.getMetaData();

            result = meta.getTables(null, null, tableName.toUpperCase(), null);

            return result.next();
        
    }

       
    
}