package mobile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.EntityType;
import model.Model;

public class PlayerTest extends CharacterTest {
    /**
     * Instantiation
     * @throws Exception value negative
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model(1);
        this.entity = this.model.getPlayer();
    }

    /**
     * Player Move
     * Method use for {@link Player#move(int, int)}
     * @throws Exception value negative
     */
    @Test
    public void testMove() throws Exception
    {
        int expectedX = 6;
        int expectedY = 3;

        assertEquals(EntityType.STONE, this.model.getMap()[3][6].getType());
        assertNull(this.model.getMap()[3][7]);

        ((Player)this.entity).move(1,0);

        assertEquals(expectedX, this.entity.getPositionX());
        assertEquals(expectedY, this.entity.getPositionY());
        assertNull(this.model.getMap()[3][5]);
        assertEquals(this.entity, this.model.getMap()[3][6]);
        assertEquals(EntityType.STONE, this.model.getMap()[3][7].getType());
    }

}
