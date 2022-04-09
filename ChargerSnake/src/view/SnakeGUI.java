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
import java.awt.event.KeyListener;
import javax.swing.*;
import model.SnakeModel;

/**
 *
 * @author jmoore
 */
public class SnakeGUI extends JPanel {

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
    private final SnakeModel model;
    private final SnakeController controller;

    SnakeGUI(SnakeController controller, SnakeModel model) {
        this.model = model;
        this.controller = controller;
        controller.initController(model, this);

        //initLocal
        window = new JFrame("Charger Snake");
        window.setFocusable(true);

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

        startButton.addActionListener(controller);

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        //Window
        window.add(GamePanel, BorderLayout.CENTER);

        window.add(MenuPanel, BorderLayout.PAGE_END);

        window.setSize(500, 600);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

    }

    public void drawStartFrame() {

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

    public void drawGamePlayFrame() {

        clearGamePanel();
        clearMenuPanel();

        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        //proof of concept - drawing rectangle the same way the snake and score obj would be drawn
        GamePanel.add(new GamePieces(model));
        GamePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        //real drawing of snake and score obj
        //GamePanel.add(new GamePieces(model));
        ////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////
        MenuPanel.add(pauseButton);

        MenuPanel.add(scoreLabel);

        MenuPanel.add(scoreTextArea);

        MenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));

        pauseButton.addActionListener(controller);

    }

    public void drawPauseFrame() {

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

        resumeButton.addActionListener(controller);

    }

    public void drawLeaderBoardFrame() {

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

        returnToStartButton.addActionListener(controller);

    }

    public void clearGamePanel() {

        GamePanel.removeAll();

        GamePanel.revalidate();

        GamePanel.repaint();

    }

    public void clearMenuPanel() {

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
}
