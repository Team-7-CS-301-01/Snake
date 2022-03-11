package controller;

import model.ModelInterface;
import model.SnakeModel;
import view.SnakeView;

public class SnakeController implements ControllerInterface {

    private SnakeModel model;
    private SnakeView view;

    public SnakeController(SnakeModel model, SnakeView view) {
        this.model = model;
        this.view = view;
    }

    public void initController() {

    }

}
