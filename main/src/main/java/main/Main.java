package main;

import contract.ControllerOrder;
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
    	Model model = new Model(5);

        UpdateMap umap = new UpdateMap(model);
        umap.start();

        ViewFrame vf = new ViewFrame();
        vf.init(model);        
        
        Controller controller = new Controller(vf, model);
        controller.start();
        controller.orderPerform(ControllerOrder.STAND_BY);

        vf.setController(controller);
        vf.Run();
       }
}
