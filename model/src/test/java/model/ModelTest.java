package model;

import entity.Level;
import mobile.Player;
import motionless.Dirt;
import motionless.Wall;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ModelTest {

	 /**  Model declaration */
    private Model model;
    /** Field declaration */
    private Field[] fields;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }



    @Before
    public void setUp() throws Exception
    {
        this.model = new Model(38);
        Class<?> modelReflector = this.model.getClass();
        this.fields = modelReflector.getDeclaredFields();
        for(Field field : this.fields) {
            field.setAccessible(true);
        }
    }

    /**
     * Get Observable
     * Test method for {@link Model#getObservable()}
     */
    @Test
    public void testGetObservable()
    {
        Model expectedModel = this.model;

        assertEquals(expectedModel, this.model.getObservable());
    }

    /**
     * Get Level
     * Test method for {@link Model#getLevel()}
     * @throws Exception value negative
     */
    @Test
    public void testGetLevel() throws Exception
    {
        Level expectedLevel = new Level(1, "");

        for(Field field : this.fields)
        {
            if(field.getName().equals("level"))
            {
                field.set(this.model, expectedLevel);
            }
        }

        assertEquals(expectedLevel, this.model.getLevel());
    }

    /**
     * Get Map
     * Test method for {@link Model#getMap()}
     * @throws Exception negative values
     */
    @Test
    public void testGetMap() throws Exception {
        Entity[][] expectedMap = null;

        for(Field field : this.fields)
        {
            if(field.getName().equals("map"))
            {
                expectedMap = (Entity[][])field.get(this.model);
            }
        }
        assertEquals(expectedMap, this.model.getMap());
    }

    /**
     * Load Level
     * Test method for {@link Model#loadLevel(int)}
     * @throws Exception value negative
     */
    @Test
    public void testLoadLevel() throws Exception
    {
        Level expectedLevel = new Level(38, "IP;I");
        Level currentLevel = null;


        for(Field field : this.fields)
        {
            if(field.getName().equals("level")) { currentLevel = (Level)field.get(this.model); }
        }


        assertEquals(expectedLevel.getId(), currentLevel.getId());
        assertEquals(expectedLevel.getLevel(), currentLevel.getLevel());
    }

    /**
     * Build Map
     * Test method for {@link Model#buildMap()}
     * @throws Exception value negative
     */
    @Test
    public void testBuildMap() throws Exception
    {
        Entity[][] expectedMap = {
                {new Wall(this.model, 0,0,EntityType.WALL)},
                {new Player(this.model,0,1)},
                {new Wall(this.model,0,2,EntityType.WALL)}
        };

        Entity[][] currentMap = null;

        for(Field field : this.fields)
        {
            if(field.getName().equals("map"))
            {
                currentMap = (Entity[][])field.get(this.model);
            }
        }
        assertEquals(expectedMap[0][0].getType(), currentMap[0][0].getType());
        assertEquals(expectedMap[1][0].getType(), currentMap[1][0].getType());
        assertEquals(expectedMap[2][0].getType(), currentMap[2][0].getType());

        assertEquals(expectedMap[0][0].getPositionX(), currentMap[0][0].getPositionX());
        assertEquals(expectedMap[1][0].getPositionX(), currentMap[1][0].getPositionX());
        assertEquals(expectedMap[2][0].getPositionX(), currentMap[2][0].getPositionX());

        assertEquals(expectedMap[0][0].getPositionY(), currentMap[0][0].getPositionY());
        assertEquals(expectedMap[1][0].getPositionY(), currentMap[1][0].getPositionY());
        assertEquals(expectedMap[2][0].getPositionY(), currentMap[2][0].getPositionY());
    }

    /**
     * Get Player
     * Test method for {@link Model#getPlayer()}
     * @throws Exception value negative
     */
    @Test
    public void testGetPlayer() throws Exception
    {
        Player expectedPlayer = null;

        for(Field field : this.fields)
        {
            if(field.getName().equals("player")) { expectedPlayer = (Player)field.get(this.model); }
        }

        assertEquals(expectedPlayer, this.model.getPlayer());
    }

    /**
     * Convert Map
     * Test method for {@link Model#convertMap()}
     */
    @Test
    public void testConvertMap()
    {
        char[][] expectedConvertedMap = new char[25][55];
        for(int y =0; y<26;y++)
            for(int x=0; x<48;x++)
            	expectedConvertedMap[y][x] = ' ';
        expectedConvertedMap[0][0] = 'B';
        expectedConvertedMap[1][0] = 'B';
        expectedConvertedMap[2][0] = 'B';

        assertArrayEquals(expectedConvertedMap, this.model.convertMap());
    }

    /**
     *
     * Update entity
     * Test method for {@link Model#updateEntity(int, int, Entity)}
     * @throws Exception value negative
     */
    @Test
    public void testUpdateEntity() throws Exception
    {
        Entity expectedEntity = new Dirt(this.model, 3,0);

        this.model.updateEntity(4,1, expectedEntity);

        assertEquals(4, expectedEntity.getPositionX());
        assertEquals(1, expectedEntity.getPositionY());
        assertEquals(expectedEntity, this.model.getMap()[1][4]);

    }
}
