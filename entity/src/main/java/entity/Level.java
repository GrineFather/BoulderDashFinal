package entity;

public class Level extends Data {
	
	/** id for the level */
    private int id;
    
    /** The data of the map */
    private String map;

    /** Constructor */
    public Level() {
        this(0, "");
    }
    
    /** Constructor */
    public Level(final int id, final String map) {
        this.setId(id);
        this.setMap(map);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) { 
    	this.id = id; 
    }
    public String getMap() {
        return this.map;
    }

    public void setMap(String map) { 
    	this.map = map; 
    }

}
