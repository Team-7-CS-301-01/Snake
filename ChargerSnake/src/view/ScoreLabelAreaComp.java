/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author jmoore
 */
public class ScoreLabelAreaComp {

    private final JLabel displayScore;

    public ScoreLabelAreaComp() {
        
        displayScore = new JLabel("Score:", JLabel.CENTER);

        displayScore.setFont(new Font("Verdana", Font.BOLD, 15));

        displayScore.setForeground(Color.BLACK);    
               
        displayScore.setText("0");
    }

    public JLabel getScoreLabelAreaComp() {

        displayScore.setSize(20, 20);

        return displayScore;

    }

}
