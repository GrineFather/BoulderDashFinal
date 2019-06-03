package motionless;

import model.Entity;
import model.EntityType;
import model.Model;

public class Exit extends Entity {

	 /** The open state of the exit */
    private boolean open;

    /**
     * Instantiates a new Exit.
     *
     * @param model associate the model
     * @param x sets the X position
     * @param y sets the Y position
     */
    public Exit(final Model model, final int x, final int y) {
        super(model,x, y,EntityType.EXIT);
    }

    /**
     * Check if the exit is open.
     *
     * @return the open state of the exit
     */
    public boolean isOpen() {
        return this.open;
    }

    /**
     * Sets the open state of the exit to true.
     */
    public void openned() { 
    	this.open = true; 
    }

}
