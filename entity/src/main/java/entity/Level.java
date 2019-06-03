package entity;

public class Level extends Data {
	
	/** id for the level */
    private int id;
    
    /** The data of the level */
    private String level;

    /** Constructor */
    public Level() {
        this(0, "");
    }
    
    /** Constructor */
    public Level(final int id, final String level) {
        this.setId(id);
        this.setLevel(level);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) { 
    	this.id = id; 
    }
    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) { 
    	this.level = level; 
    }

}
