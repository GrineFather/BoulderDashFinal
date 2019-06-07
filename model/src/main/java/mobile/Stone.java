package mobile;

import model.EntityType;
import model.Model;

public class Stone extends Slidingblock {

	 /**
     * Instantiates a new RollingRock.
     *
     * @param model associate the model
     * @param x sets the X position
     * @param y sets the Y position
     */
	public Stone(final Model model, final int x, final int y)
    {
        super(model,x,y,EntityType.STONE);
    }

    /**
     * Try to move the entity if the player pushes it from the side.
     *
     * @param move sets the direction you try to pushed it
     * @return true if the entity move is a success and false if not
     * @throws Exception when the given positions are out of the world
     */
    boolean moved(final Move move) throws Exception
    {
        int antX = getPositionX();
        int antY = getPositionY();

        if(move==Move.RIGHT)
        {
           if ( getRelativeEntity(1,0) == null)
           {
               this.model.updateEntity(getPositionX()+1,getPositionY(),this);
               this.model.updateEntity(antX,antY,null);
               return true;
           }
           return false;
        }else if(move==Move.LEFT) {
            if(getRelativeEntity(-1,0) == null)
            {
                this.model.updateEntity(getPositionX()-1,getPositionY(),this);
                this.model.updateEntity(antX,antY,null);
                return true;
            }
            return false;
        }
        return false;
    }
}