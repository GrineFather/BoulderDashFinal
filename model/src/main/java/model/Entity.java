package model;


public abstract class Entity {

	   /** The model*/
	    protected Model model;
	    /** The X position */
	    private int positionX;
	    /** The Y position */
	    private int positionY;
	    /** The type of the entity */
	    private EntityType type;

	    /**
	     * Instantiates a new Entity.
	     *
	     * @param model associate the model
	     * @param positionX sets the X position
	     * @param positionY sets the Y position
	     * @param type sets the type of the entity
	     */
	    public Entity(final Model model, final int positionX, final int positionY, final EntityType type) {
	        this.model = model;
	        this.positionY = positionY;
	        this.positionX = positionX;
	        this.type = type;
	    }

	    /**
	     * Gets the X position.
	     *
	     * @return the X position
	     */
	    public int getPositionX() {
	        return this.positionX;
	    }

	    /**
	     * Sets the X position.
	     *
	     * @param x the new X position
	     * @throws Exception when the given position is out of the world
	     */
	    void setPositionX(final int x) throws Exception {
	        if(x<0) {
	            throw new Exception("The X position cannot be negative");
	        }
	        else {
	            this.positionX = x;
	        }
	    }

	    /**
	     * Gets the Y position.
	     *
	     * @return the Y position
	     */
	    public int getPositionY() {
	        return positionY;
	    }

	    /**
	     * Sets the Y position.
	     *
	     * @param y the new Y position
	     * @throws Exception when the given position is out of the world
	     */
	    void setPositionY(final int y) throws Exception {
	        if(y<0) {
	            throw new Exception("The Y position cannot be negative");
	        }
	        else {
	            this.positionY = y;
	        }
	    }

	    /**
	     * Gets the type.
	     *
	     * @return the type
	     */
	    public EntityType getType() {
	            return type;
	    }

	    /**
	     * Gets an entity retrieved in the world with a relative position.
	     *
	     * @param x the X relative position
	     * @param y the Y relative position
	     * @return the entity found
	     */
	    public Entity getRelativeEntity(final int x, final int y) {
	        return this.model.getMap()[positionY+y][positionX+x];
	    }
	}
