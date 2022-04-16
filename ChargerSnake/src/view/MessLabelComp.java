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
public class MessLabelComp {
    
    public JLabel getMessLabelComp() {
        
        String mess = "Enter a name and click start. Use arrow keys to move.";
        
        JLabel labelOne = new JLabel(mess, JLabel.CENTER);

        labelOne.setFont(new Font("Verdana", Font.BOLD, 15));

        labelOne.setForeground(Color.BLUE);
        
        return labelOne;
        
    }
    
}
