package controller;

import model.ModelInterface;
import model.SnakeModel;
import view.SnakeFrame;

public class SnakeController implements ControllerInterface {

    private SnakeModel model;
    private SnakeFrame view;

    public SnakeController(SnakeModel model, SnakeFrame view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {
        
        
    }

}
