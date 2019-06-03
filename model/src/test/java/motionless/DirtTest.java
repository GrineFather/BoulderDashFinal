package motionless;

import org.junit.Before;

import model.EntityTest;
import model.Model;

public class DirtTest extends EntityTest {
	
    /**
     * Instantiation and recovery of a dirt type entity in the level
     * @throws Exception if the position values are negatives
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(1);
        new Dirt(model,5,6);
    }

}
