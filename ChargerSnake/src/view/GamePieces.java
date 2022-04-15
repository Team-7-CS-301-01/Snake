/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.SnakeModel;

/**
 *
 * @author jmoore
 */
public class GamePieces extends JPanel {

    private final SnakeModel model;

    public GamePieces(SnakeModel m) {
        this.model = m;
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < model.getBOARD_WIDTH() / model.getUNIT_SIZE(); i++) {
            g.drawLine(i * model.getUNIT_SIZE(), 0, i * model.getUNIT_SIZE(), model.getBOARD_LENGTH());
            g.drawLine(0, i * model.getUNIT_SIZE(), model.getBOARD_WIDTH(), i * model.getUNIT_SIZE());
        }

        g.setColor(Color.red);
        g.fillOval(model.getScoreObject(0).getx(), model.getScoreObject(0).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());

        for (int i = 0; i < model.getSnakeLength(); i++) {
            if (i == 0) {
                g.setColor(Color.green);
                g.fillRect(model.getSnake(i).getx(), model.getSnake(i).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());
            } else {
                g.setColor(new Color(100, 180, 0));
                g.fillRect(model.getSnake(i).getx(), model.getSnake(i).gety(), model.getUNIT_SIZE(), model.getUNIT_SIZE());
            }
        }
    }

}
