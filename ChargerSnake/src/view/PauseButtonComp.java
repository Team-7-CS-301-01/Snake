/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author jmoore
 */
public class PauseButtonComp {
    
    public JButton getPauseButtonComp() {
        
        JButton pause = new JButton("Pause");

        pause.setFont(new Font("Verdana", Font.BOLD, 15));
        
        return pause;
        
    }
}
