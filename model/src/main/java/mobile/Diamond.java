package mobile;

import model.EntityType;
import model.Model;

public class Diamond extends Slidingblock {

	/**
     * Instantiates a new Diamond.
     *
     * @param model associate the model
     * @param x sets the X position
     * @param y sets the Y position
     */
    public Diamond(final Model model, final int x, final int y) {
        super(model,x,y,EntityType.DIAMOND);
    }
}
