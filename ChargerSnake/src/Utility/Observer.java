package Utility;

/**
 * 
 * @author jmoore
 * Used by the view to receive instruction from the model
 */
public interface Observer {

    public void update(Message m);

}
