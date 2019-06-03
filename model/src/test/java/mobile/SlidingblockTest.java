package mobile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.EntityTest;
import model.EntityType;

public class SlidingblockTest extends EntityTest {

	@Before
    public void setUp() throws Exception {

    }

    /**
     * Fall
     * Method use for {@link Slidingblock#fall()}
     * @throws Exception value negative
     */
    @Test
    public void testFall() throws Exception
    {
        if(this.entity instanceof Stone)
        {
            int expectedY = 5;
            ((Slidingblock)this.entity).fall();
            assertEquals(expectedY, this.entity.getPositionY());

            assertEquals(EntityType.PLAYER, this.model.getPlayer().getType());
            assertTrue(this.model.getPlayer().isAlive());

            ((Slidingblock)this.entity).fall();

            assertFalse(this.model.getPlayer().isAlive());
            assertNull(this.model.getMap()[this.entity.getPositionY()][this.entity.getPositionX()]);
        }
    }

    /**
     * Sliding Entity
     * Method use for {@link Slidingblock#slide(boolean)}
     * @throws Exception value negative
     */
    @Test
    public void testSlide() throws Exception
    {
        if(this.entity instanceof Diamond)
        {
            int expectedX = 11;
            assertNull(this.model.getMap()[4][11]);
            assertNull(this.model.getMap()[5][11]);
            assertTrue(this.model.getMap()[5][12] instanceof Slidingblock);

            ((Slidingblock)this.entity).slide(true);
            assertEquals(expectedX, this.entity.getPositionX());
        }
    }

}
