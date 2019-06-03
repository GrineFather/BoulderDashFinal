package mobile;

import model.Model;
import model.EntityType;
import motionless.Exit;

public class Player extends Character {

    /** The alive state of the player */
    private boolean alive;

    /**
     * Instantiates a new Player.
     *
     * @param model associate the model
     * @param x sets the X position
     * @param y sets the Y position
     */
    public Player(final Model model, final int x, final int y)
    {
        super(model,x,y,EntityType.PLAYER);
        this.alive = true;
    }

    /**
     * Tries to move the player to a relative place.
     * Check if the new place is a diamond (picks it up), a rolling rock (pushes her) or an exit (wins if it is open).
     *
     * @param x sets the X relative position
     * @param y sets the Y relative position
     * @throws Exception when the given positions are out of the world
     */
    public void move(final int x, final int y) throws Exception
    {
        int antX = getPositionX();
        int antY = getPositionY();
        if(getRelativeEntity(x,y) == null || getRelativeEntity(x,y).getType() == EntityType.DIRT)
        {
            this.model.updateEntity(getPositionX()+x, getPositionY()+y, this);
            this.model.updateEntity(antX, antY, null);

        }
        else if(getRelativeEntity(x,y) != null && getRelativeEntity(x,y).getType() == EntityType.STONE)
        {
            if(x < 0)
            {
                if(((Stone)getRelativeEntity(x,y)).moved(Move.LEFT))
                {
                    this.model.updateEntity(getPositionX()+x, getPositionY()+y, this);
                    this.model.updateEntity(antX, antY, null);

                }
            }
            else if (x > 0)
            {
                if(((Stone)getRelativeEntity(x,y)).moved(Move.RIGHT))
                {
                    this.model.updateEntity(getPositionX()+x, getPositionY()+y, this);
                    this.model.updateEntity(antX, antY, null);

                }
            }
        }
        else if(getRelativeEntity(x,y) != null && getRelativeEntity(x,y).getType() == EntityType.EXIT && ((Exit)getRelativeEntity(x,y)).isOpen())
        {
            this.model.updateEntity(getPositionX()+x, getPositionY()+y, this);
            this.model.updateEntity(antX, antY, null);
            this.model.winned();
        }
        else if(getRelativeEntity(x,y) != null && getRelativeEntity(x,y).getType() == EntityType.DIAMOND)
        {
            this.model.updateEntity(getPositionX()+x, getPositionY()+y, this);
            this.model.updateEntity(antX, antY, null);
        }
    }

    /**
     * Changes the alive state of the player to false.
     */
    public void die() {
       
        this.alive = false;
    }

    /**
     * Check if the player is steel alive.
     *
     * @return the alive state of the player
     */
    public boolean isAlive() {
        return this.alive;
    }

}
