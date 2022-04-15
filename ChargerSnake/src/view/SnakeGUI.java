/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Utility.Message;
import Utility.Observer;
import Utility.Player;
import controller.SnakeController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.SnakeModel;

/**
 *
 * @author jmoore
 */
public class SnakeGUI implements Observer {

    private final JFrame window;
    private final JPanel GamePanel;
    private final JPanel MenuPanel;
    private final JButton startButton;
    private final JLabel chargerSnakeMess;
    private final JLabel enterNameMess;
    private final JTextField inputField;
    private final JButton pauseButton;
    private final JLabel scoreLabel;
    private final JLabel scoreLabelArea;
    private final JLabel pauseLabel;
    private final JButton resumeButton;
    private final JButton returnToStartButton;
    private final SnakeModel model;
    private final SnakeController controller;

    SnakeGUI(SnakeController controller, SnakeModel model) {
        
        this.model = model;

        this.controller = controller;

        //initLocal
        window = new JFrame("Charger Snake");

        controller.initController(model, this);

        GamePanel = new JPanel();

        MenuPanel = new JPanel();

        chargerSnakeMess = new ChargerSnakeComp().getChargerSnakeComp();

        enterNameMess = new MessLabelComp().getMessLabelComp();

        startButton = new StartButtonComp().getStartButtonComp();

        inputField = new InputFieldComp().getInputFieldComp();

        pauseButton = new PauseButtonComp().getPauseButtonComp();

        scoreLabel = new ScoreLabelComp().getScoreLabelComp();

        scoreLabelArea = new ScoreLabelAreaComp().getScoreLabelAreaComp();

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

        startButton.addActionListener(controller);

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        //Window
        window.add(GamePanel, BorderLayout.CENTER);

        window.add(MenuPanel, BorderLayout.PAGE_END);

        window.setSize(500, 600);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.setLocationRelativeTo(null);
        
        window.setVisible(true);

        window.setResizable(false);

        window.pack();

        window.setFocusable(true);
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
        GamePanel.add(new GamePieces(model));
        
        GamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        MenuPanel.add(pauseButton);

        MenuPanel.add(scoreLabel);

        MenuPanel.add(scoreLabelArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        pauseButton.addActionListener(controller);

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

        MenuPanel.add(scoreLabelArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        resumeButton.addActionListener(controller);

    }

    private void drawLeaderBoardFrame() {

        clearGamePanel();
        
        clearMenuPanel();

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        GamePanel.add(new LeaderBoard(model));

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        MenuPanel.add(returnToStartButton);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        returnToStartButton.addActionListener(controller);

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
        new SnakeGUI(new SnakeController(), new SnakeModel());

    }

    public JButton getStart() {
        return startButton;
    }

    public JButton getPause() {
        return pauseButton;
    }

    public JButton getResume() {
        return resumeButton;
    }

    public JButton getReturnStart() {
        return returnToStartButton;
    }

    public JFrame getGameFrame() {
        return window;
    }
    
    public String getName() {
        return inputField.getText();
    }
    
    
    

    @Override
    public void update(Message m) {
        
        switch (m.getMessageContent()) {
            case "DrawStartFrame":
                    drawStartFrame();
                    break;   
            case "DrawLeaderBoardFrame":
                    drawLeaderBoardFrame();
                    break;
            case "DrawGamePlayFrame":
                    drawGamePlayFrame();
                    break;        
            case "DrawPauseFrame":
                    drawPauseFrame();
                    break;        
            case "RePaintGameFrame":
                    window.repaint();
                    break;              
            case "ClearName":
                    inputField.setText("");
                    break;
            case "UpdateScore":
                    scoreLabelArea.setText(Integer.toString(model.getScore()));
                    break;                    
         }
       
    }
    
    
 
    
    
   }


