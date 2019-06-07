package model;

public class UpdateMap extends Thread {

    private Model model;

    public UpdateMap(Model model) {
        this.model = model;
    }

    public void run() {
        while(true) {
            try {
            	this.model.updateSlidingblocks();

                Thread.sleep(250);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
