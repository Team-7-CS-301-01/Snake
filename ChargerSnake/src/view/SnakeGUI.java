/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SnakeController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.SnakeModel;


/**
 *
 * @author jmoore
 */
public class SnakeGUI implements ActionListener {

    private final JFrame window;
    private final JPanel GamePanel;
    private final JPanel MenuPanel;
    private final JButton startButton;
    private final JLabel chargerSnakeMess;
    private final JLabel enterNameMess;
    private final JTextField inputField;
    private final JButton pauseButton;
    private final JLabel scoreLabel;
    private final JTextArea scoreTextArea;
    private final JLabel pauseLabel;
    private final JButton resumeButton;
    private final JButton returnToStartButton;
    private SnakeModel model;
    private SnakeController controller;
    
    
    SnakeGUI() {
        
        model = new SnakeModel();
        
        controller = new SnakeController(model, this);
        
        
      
        //initLocal
        window = new JFrame("Charger Snake");
        
        GamePanel = new JPanel();
        
        MenuPanel = new JPanel();
        
        chargerSnakeMess = new ChargerSnakeComp().getChargerSnakeComp();
        
        enterNameMess = new MessLabelComp().getMessLabelComp();
        
        startButton = new StartButtonComp().getStartButtonComp();
        
        inputField = new InputFieldComp().getInputFieldComp();
        
        pauseButton = new PauseButtonComp().getPauseButtonComp();
        
        scoreLabel = new ScoreLabelComp().getScoreLabelComp();
        
        scoreTextArea = new ScoreTextAreaComp().getScoreTextAreaComp();
        
        pauseLabel = new PauseLabelComp().getPauseLabelComp();
        
        resumeButton = new ResumeButtonComp().getResumeButtonComp();
        
        returnToStartButton = new ReturnStartComp().getReturnStartComp();
        
        
        //Player needed for user info
        
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
                
        
        
        
        
        //GamePanel
        GamePanel.setBackground(Color.black);
        
        GamePanel.setPreferredSize(new Dimension(500, 500));
        
        GamePanel.add(chargerSnakeMess);

        GamePanel.add(enterNameMess);

        GamePanel.setLayout(new GridLayout(3, 1, 0, 5));
        
     
      
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
        
        
        //MenuPanel
        MenuPanel.setBackground(Color.gray);
        
        MenuPanel.setPreferredSize(new Dimension(500, 100));     
        
        
        MenuPanel.add(inputField);

        MenuPanel.add(startButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        
        
        startButton.addActionListener(this);
        
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////

        
        
        
        
        
        
        //Window
        window.add(GamePanel, BorderLayout.CENTER);
        
        window.add(MenuPanel, BorderLayout.PAGE_END);
        
        window.setSize(500, 600);
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setVisible(true);
        
        
    }
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
      Object obj = e.getSource();
      
      if (obj == startButton) {
        //save player name in Player obj in model
        //store till game ends
        //then send that info to database to see if it earns spot 
        
        
        //call func to update score
        drawGamePlayFrame();
      } 
      if (obj == pauseButton) {
        //call func to update score
        drawPauseFrame();
      }
      if(obj == resumeButton) {
        //call func to update score
        drawGamePlayFrame();
      }
      if(obj == returnToStartButton)
      {
          drawStartFrame();
      }
      
    }    
    
   
    
    
    private void drawStartFrame() {
        
        clearGamePanel();
        clearMenuPanel();
        
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
        
        GamePanel.add(chargerSnakeMess);

        GamePanel.add(enterNameMess);

        GamePanel.setLayout(new GridLayout(3, 1, 0, 5));
        
        
      
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
        
        
        
        MenuPanel.add(inputField);

        MenuPanel.add(startButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        
  
    }
    
    
    
    private void drawGamePlayFrame() {
        
        clearGamePanel();
        clearMenuPanel();
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
        //proof of concept - drawing rectangle the same way the snake and score obj would be drawn
        GamePanel.add(new MyRect());
        GamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));


        //real drawing of snake and score obj
        //GamePanel.add(new GamePieces(model));
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////

 
        MenuPanel.add(pauseButton);

        MenuPanel.add(scoreLabel);

        MenuPanel.add(scoreTextArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
     
        pauseButton.addActionListener(this);

    }
    
    
    
    
    
    private void drawPauseFrame() {
        
        clearGamePanel();
        clearMenuPanel();
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
        
        GamePanel.add(pauseLabel);

        GamePanel.setLayout(new GridLayout(3, 1, 0, 5));
      

        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
    
        
        MenuPanel.add(resumeButton);

        MenuPanel.add(scoreLabel);

        MenuPanel.add(scoreTextArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        
        resumeButton.addActionListener(this);

        
    }
    
    
    
    
    private void drawLeaderBoardFrame() {
        
        
        clearGamePanel();
        clearMenuPanel();
        
        ////////////////////////////////////////////////////////////////  
        ////////////////////////////////////////////////////////////////
        
        //LeaderBoard needs work
        //The output on the last row is being cut off
        GamePanel.add(new LeaderBoard());
        
        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        
  

        MenuPanel.add(returnToStartButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        returnToStartButton.addActionListener(this);

        
        
    }
    
    
    
    private void clearGamePanel() {
        
        GamePanel.removeAll();
        
        GamePanel.revalidate();
        
        GamePanel.repaint();   
        
    }
    
    
    
    private void clearMenuPanel() {
        
        MenuPanel.removeAll();
        
        MenuPanel.revalidate();
        
        MenuPanel.repaint();    
        
    }
    

    
    public static void main(String[] args) {
        
        SnakeGUI view = new SnakeGUI();
        
    }

    
    
    
    
  
    public void addKeyListener(SnakeController.GameController gameController) {
        System.out.println("don't know what to do yet");
    }
 
}
