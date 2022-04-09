/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.JTextArea;

/**
 *
 * @author jmoore
 */
public class ScoreTextAreaComp {
    
    public JTextArea getScoreTextAreaComp() {

        JTextArea displayScore = new JTextArea(2, 5);

        displayScore.setSize(20, 20);    
        
        return displayScore;
        
    }
    
}
