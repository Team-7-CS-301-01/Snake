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
    private ArrayList<Player> players;
    
    LeaderBoard() {
        this.setPreferredSize(new Dimension(500, 470));

        this.setBackground(Color.black);
                
        this.setLayout(new GridLayout(10, 3, 5, 5));
        
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Name");
        labels.add("Score");
        labels.add("Time Played");
        for (int i = 0; i < 3; i++) {
           JLabel l = new JLabel();
           l.setForeground(Color.BLUE);
           l.setFont(new Font("Verdana", Font.BOLD, 14)); 
           l.setVerticalAlignment(JLabel.TOP);
           l.setHorizontalAlignment(JLabel.CENTER);
           l.setPreferredSize(new Dimension(50, 50));
           l.setText(labels.get(i));
           this.add(l);
        }
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        addScore("Jacob", "10", "100");
        
        
       
    }
    
   void addScore(String name, String score, String time)        // TODO: Add scores to player list array, sort, and then add to screen.
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
   
   void sort()
   {
       
   }
}