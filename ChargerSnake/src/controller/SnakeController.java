package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import model.SnakeModel;
import view.SnakeView;

public class SnakeController implements ActionListener {

    private SnakeModel model;
    private SnakeView view;

    public SnakeController(SnakeModel model, SnakeView view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        model.initGame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.isRunning()) {
            model.moveSnake();
            model.checkScoreObject();
            model.checkCollision();
        }
    }
}
