/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jmoore
 */
class MyRect extends JPanel {
    

    
    @Override
    public void paintComponent(Graphics g) {
        
      super.paintComponent(g);
      
      g.setColor(Color.red);
      g.fillRect(40, 40, 100, 100);
      
      
    }
}