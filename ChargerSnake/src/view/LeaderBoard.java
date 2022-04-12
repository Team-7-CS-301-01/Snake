/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Utility.Database;
import Utility.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.SnakeModel;

/**
 *
 * @author jmoore
 */
public class LeaderBoard extends JPanel {
    
    LeaderBoard(SnakeModel model) {
        
        ArrayList<Player> pList = model.getPlayerList();
        
        
        this.setPreferredSize(new Dimension(500, 470));

        this.setBackground(Color.black);
                
        this.setLayout(new GridLayout(11, 3, 1, 1));
        
        displayHeaders();
        for(int i = 0; i < 10; i++)
        {
            Player p = pList.get(i);
            displayScore(p.getName(), p.getScore(), p.getTime());
        }
       
        
        
    }
    void displayScore(String name, String score, String time)        // TODO: Add scores to player list array, sort, and then add to screen.
   {
        JLabel n = new JLabel();
        n.setForeground(Color.BLUE);
        n.setFont(new Font("Verdana", Font.BOLD, 14));
        n.setText(name);
        n.setVerticalAlignment(JLabel.TOP);
        n.setHorizontalAlignment(JLabel.CENTER);
        n.setPreferredSize(new Dimension(50, 50));
        this.add(n);    
        
        JLabel s = new JLabel();
        s.setForeground(Color.BLUE);
        s.setFont(new Font("Verdana", Font.BOLD, 14));
        s.setText(score);
        s.setVerticalAlignment(JLabel.TOP);
        s.setHorizontalAlignment(JLabel.CENTER);
        s.setPreferredSize(new Dimension(50, 50));
        this.add(s);
        
        JLabel t = new JLabel();
        t.setForeground(Color.BLUE);
        t.setFont(new Font("Verdana", Font.BOLD, 14));
        t.setText(time);
        t.setVerticalAlignment(JLabel.TOP);
        t.setHorizontalAlignment(JLabel.CENTER);
        t.setPreferredSize(new Dimension(50, 50));
        this.add(t);
   }
   void displayHeaders() {
       JLabel n = new JLabel();
        n.setForeground(Color.BLUE);
        n.setFont(new Font("Verdana", Font.BOLD, 16));
        n.setText("Name");
        n.setVerticalAlignment(JLabel.TOP);
        n.setHorizontalAlignment(JLabel.CENTER);
        n.setPreferredSize(new Dimension(50, 50));
        this.add(n);    
        
        JLabel s = new JLabel();
        s.setForeground(Color.BLUE);
        s.setFont(new Font("Verdana", Font.BOLD, 16));
        s.setText("Score");
        s.setVerticalAlignment(JLabel.TOP);
        s.setHorizontalAlignment(JLabel.CENTER);
        s.setPreferredSize(new Dimension(50, 50));
        this.add(s);
        
        JLabel t = new JLabel();
        t.setForeground(Color.BLUE);
        t.setFont(new Font("Verdana", Font.BOLD, 16));
        t.setText("Time Alive");
        t.setVerticalAlignment(JLabel.TOP);
        t.setHorizontalAlignment(JLabel.CENTER);
        t.setPreferredSize(new Dimension(50, 50));
        this.add(t);
   }
   
}