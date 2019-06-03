package motionless;

import org.junit.Before;

import model.EntityTest;
import model.Model;

public class ExitTest extends EntityTest {

	/**
     * @throws Exception position not null
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(1);
        this.entity = new Exit(model,5,6);
    }

}
