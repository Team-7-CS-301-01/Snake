/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jmoore
 */
public class LeaderBoard extends JPanel {
    
    LeaderBoard() {
        this.setPreferredSize(new Dimension(500, 490));

        this.setBackground(Color.black);
                
        this.setLayout(new GridLayout(11, 3, 1, 1));
        
        for (int i = 1; i <= 44; i++) {
           JLabel l = new JLabel();
           l.setForeground(Color.BLUE);
           l.setFont(new Font("Verdana", Font.BOLD, 14));
           l.setText("hey");
           l.setVerticalAlignment(JLabel.TOP);
           l.setHorizontalAlignment(JLabel.CENTER);
           l.setPreferredSize(new Dimension(15, 15));
           this.add(l);
           
        }
        
    }
    
   
}