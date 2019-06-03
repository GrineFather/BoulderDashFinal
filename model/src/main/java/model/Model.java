package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.Level;
import mobile.Diamond;
import mobile.Player;
import mobile.Slidingblock;
import mobile.Stone;
import motionless.Dirt;
import motionless.Exit;
import motionless.Wall;

/**
 * The Class Model
 *
 * @author Rowan Geeraert
 */

public final class Model extends Observable implements IModel {

	/** The level of map */
	private Level level;
	
	/** The map */
	private Entity[][] map = new Entity[25][55];
	
	/** Instantiation of player */
	private Player player;
	
	/** Attribute win */
	private boolean win;
	
	/** Attribute exit */
	private Exit exit;

	/**
	 * Instantiates a new model.
	 *
	 * @param levelID
	 * 			the ID of the level in the database
	 */
	public Model(int id) throws Exception {
		this.loadLevel(id);
		this.buildMap();
	}

	/**
	 * Load the level from the database.
	 *
	 * @param levelID
	 * 			the ID of the level in the database
	 */
	private void loadLevel(int id) {
		try {
			final DAOLevel daoLevel = new DAOLevel(DBConnection.getInstance().getConnection());
			this.level = daoLevel.find(id);
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Convert the level extracted from the database to an usable Entity array in two dimension.
	 */
	private void buildMap() {
		int x = 0;
		int y = 0;
		for(char c : level.getLevel().toCharArray()) {
			if(c == ';') {
				y++;
				x = 0;
			}
			else {
				switch (c) {	
					case 'P' :
						map[y][x] = new Player(this, x,y);
						this.player = (Player)map[y][x];
						break;
					case 'B' :
						map[y][x] = new Dirt(this, x,y);
						break;
					case 'G' :
						map[y][x] = new Stone(this, x,y);
						break;
					case 'D' :
						map[y][x] = new Diamond(this, x,y);
						break;
					case 'I' :
						map[y][x] = new Wall(this, x,y, EntityType.INLINE);
						break;
					case 'E' :
						map[y][x] = new Exit(this, x,y);
						break;
					case 'O' :
						map[y][x] = new Wall(this, x,y, EntityType.WALL);
						break;
				}
				x++;
			}
		}
	}

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	public Observable getObservable() { 
		return this; 
	}

	/**
	 * Gets the level.
	 *
	 * @return the level
	 */
	public Level getLevel() { 
		return this.level; 
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public Entity[][] getMap() { 
		return this.map; 
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() { 
		return this.player; 
	}

	/**
	 * Update a slot in the map array and notify the observers.
	 *
	 * @param x
	 * 			the x position of the updated slot
	 * @param y
	 * 			the y position of the updated slot
	 * @param entity
	 * 			the entity put in the slot (can be null)
	 *
	 * @throws Exception when a bad position is given in parameter
	 */
	public void updateEntity(final int x, final int y, Entity entity) throws Exception {
	    if(entity != null)
        {
            entity.setPositionX(x);
            entity.setPositionY(y);
        }

	    map[y][x] = entity;

		setChanged();
		notifyObservers();
	}

    /**
     * Try to update every sliding block in the map if they can move.
	 *
     * @throws Exception when there was a bad move
     */
	void updateSlidingblocks() throws Exception {
		for(Entity[] line : map)
		{
			for(Entity e : line)
			{
				if(e instanceof Slidingblock)
				{
					((Slidingblock) e).pathFinder();
				}
			}
		}

		for(Entity[] line : map)
		{
			for(Entity e : line)
			{
				if(e instanceof Slidingblock)
				{
					((Slidingblock) e).resetMove();
				}
			}
		}
	}

	/**
	 * Convert the world to a char array in two dimensions.
	 *
	 * @return the converted char array
	 */
	public char[][] convertMap() {
		char[][] cw = new char[20][30];

		for(int y = 0; y<20; y++)
		{
			for(int x = 0; x<30; x++)
			{
				if(map[y][x] != null) {
					switch (map[y][x].getType()) {
						case DIRT:
							cw[y][x] = 'B';
							System.out.print("B");
							break;
						case DIAMOND:
							cw[y][x] = 'D';
							System.out.print("D");
							break;
						case PLAYER:
							cw[y][x] = 'P';
							System.out.print("P");
							break;
						case INLINE:
							cw[y][x] = 'I';
							System.out.print("I");
							break;
						case WALL:
							cw[y][x] = 'O';
							System.out.print("O");
							break;
						case EXIT:
							cw[y][x] = 'E';
							System.out.print("E");
							break;
						case STONE:
							cw[y][x] = 'G';
							System.out.print("G");
							break;
						default:
							cw[y][x] = ' ';
							break;
					}
				}
				else
				{
					cw[y][x] = ' ';
				}
			}
		}

        return cw;
	}

	/**
	 * Gets the win state.
	 *
	 * @return the win state
	 */
	public boolean isWin() { 
		return this.win; 
	}

	/**
	 * Sets the win state to true. Also notify the observers.
	 */
	public void winned()
	{
		this.win = true;
		setChanged();
		notifyObservers();
	}

	
	/**
	 * Gets the alive state from the player.
	 *
	 * @return the alive state from the player
	 */
    public boolean getIsAlivePlayer() {
        return this.getPlayer().isAlive();
    }

	/**
	 * Try to move the player.
	 *
	 * @param x
	 * 			the x position of the move
	 * @param y
	 * 			the y position of the move
	 *
	 * @throws Exception when a bad position is given in parameter
	 */
    public void setMovePlayer(final int x, final int y) throws Exception
    {
        this.getPlayer().move(x, y);
    }

	/**
	 * Gets the position of the player.
	 *
	 * @return the position of the player
	 */
    public int[] getPositionsPlayer()
	{
		int[] pos = new int[2];
		pos[2] = this.getPlayer().getPositionX();
		pos[2] = this.getPlayer().getPositionY();
		return pos;
	}

	/**
	 * Gets the open state of the exit.
	 *
	 * @return the open state of the exit
	 */
	public boolean getIsOpenExit() {
		return this.exit.isOpen();
	}
}
