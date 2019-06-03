package mobile;

import org.junit.Before;

import model.Entity;
import model.EntityType;
import model.Model;

public class DiamondTest extends SlidingblockTest {

	/**
     * Instantiation and recovery of a diamond type entity in the level
     * @throws Exception if position values is negatives
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(1);

        outerloop:
        for(Entity[] etab : this.model.getMap())
            for(Entity e : etab)
                if(e != null && e.getType() == EntityType.DIAMOND)
                {
                    this.entity = (Slidingblock) e;
                    break outerloop;
                }
    }

}
