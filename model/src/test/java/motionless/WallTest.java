package motionless;

import org.junit.Before;

import model.EntityTest;
import model.EntityType;
import model.Model;

public class WallTest extends EntityTest {

	@Before
    public void setUp() throws Exception {
        this.model = new Model(1);
        this.entity = new Wall(model,5,6, EntityType.WALL);
    }

}
