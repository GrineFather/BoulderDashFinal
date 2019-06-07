package mobile;

import model.Entity;
import model.EntityType;
import model.Model;

public abstract class Character extends Entity {

    /** Every position possible around one block */
    final int[][] POSITIONS = {
            {0,0},
            {0,1},
            {1,1},
            {1,0},
            {-1,1},
            {-1,0},
            {-1,-1},
            {0,-1},
            {1,-1}
    };

    /**
     * Instantiates a new Character.
     *
     * @param model associate the model
     * @param x sets the X position
     * @param y sets the Y position
     * @param type sets the type of the character
     */
    Character(final Model model, final int x, final int y, final EntityType type) {
        super(model,x,y,type);
    }

    /**
     * The move method. Need to be redefined.
     *
     * @param x sets the X position
     * @param y sets the Y position
     * @throws Exception when the given positions are out of the world
     */
    public abstract void move(final int x, final int y) throws Exception;

    /**
     * The die method. Need to be redefined.
     *
     * @throws Exception when the given positions are out of the world
     */
    public abstract void die() throws Exception;
}
