/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.SnakeModel;
/**
 *
 * @author jmoore
 */
public class GamePieces extends JPanel {
    
    private SnakeModel model;
    
    public GamePieces(SnakeModel m)
    {
        this.model = m;
    }
        
    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      
              g.setColor(Color.red);
        g.fillOval(model.getScoreObject(0).getx(), model.getScoreObject(0).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());

        for (int i = 0; i < model.getSnakeLength(); i++) {
            if (i == 0) {
                g.setColor(Color.green);
                g.fillRect(model.getSnake(i).getx(), model.getSnake(i).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());
            } else {
                g.setColor(new Color(45, 180, 0));
            }
        }
    }
    
    
}
