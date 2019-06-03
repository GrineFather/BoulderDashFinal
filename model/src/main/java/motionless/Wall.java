package motionless;

import model.Entity;
import model.EntityType;
import model.Model;

public class Wall extends Entity {
    /**
     * Instantiates a new Wall.
     *
     * @param model associate the model
     * @param x sets the X position
     * @param y sets the Y position
     * @param type sets the type of the wall
     */
    public Wall(final Model model, final int x, final int y, final EntityType type)
    {
        super(model,x,y,type);
    }

}

