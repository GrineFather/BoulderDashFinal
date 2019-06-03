package mobile;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.Entity;
import model.EntityType;
import model.Model;

public class StoneTest extends SlidingblockTest {

	/**
     * Instantiation and recovery of a Stone type entity in the level
     * @throws Exception value negative
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(1);
        outerloop:
        for(Entity[] etab : this.model.getMap())
            for(Entity e : etab)
                if(e != null && e.getType() == EntityType.STONE)
                {
                    this.entity = (Slidingblock) e;
                    break outerloop;
                }

    }


    /**
     * Moved
     * Method use for {@link Stone#moved(Direction)}
     * @throws Exception value negative
     */
    @Test
    public void moved() throws Exception {
        ((Stone) this.entity).moved(Move.RIGHT);
        int expectedX = 8;
        Assert.assertEquals(expectedX,this.entity.getPositionX());

    }

}
