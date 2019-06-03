package main;

import controller.Controller;
import model.Model;
import model.UpdateMap;
import view.ViewFrame;

/**
 * The Class Main.
 *
 * @author Rowan Geeraert
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws Exception 
     */
    public static void main(final String[] args) throws Exception {
    	Model model = new Model(1);

        UpdateMap umap = new UpdateMap(model);
        umap.start();

        ViewFrame viewframe = new ViewFrame(model);
        
        Controller controller = new Controller(viewframe, model);
        controller.start();

        viewframe.setController(controller);
	}
}
