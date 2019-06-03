 package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class ViewFrame.
 *
 * @author Mattie Langlois
 */
public class ViewFrame extends JFrame implements IView, KeyListener, Observer {

	private ViewPanel panel;
	 
	 /** The model. */
	 private IModel      model;
	 /** The controller. */
	 private IController    controller;
			 
	 /** The Constant serialVersionUID. */
	 private static final long serialVersionUID = -697358409737458175L;
	 
	 /**
	  * Gets the controller.
	  *
	  * @return the controller
	  */
	 private IController getController() {
	  return this.controller;
	 }
	 
	 /**
	  * Sets the controller.
	  *
	  * @param controller
	  *          the new controller
	  */
	 public void setController(final IController controller) {
	  this.controller = controller;
	 }
	 
	 /**
	  * Gets the model.
	  *
	  * @return the model
	  */
	 protected IModel getModel() {
	  return this.model;
	 }
	 
	 /**
	  * Sets the model.
	  *
	  * @param model
	  *          the new model
	  */
	@SuppressWarnings("unused")
	private void setModel(final IModel model){
	  this.model = model;
	 }
	
	 /**
	  * Builds the view frame.
	  *
	  * @param model
	  *          the model
	  */
	 public ViewFrame(IModel model) {
		 this.panel = new ViewPanel();
	     this.model = model;
	     this.model.getObservable().addObserver(this);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 this.addKeyListener(this);
		 this.setContentPane(panel);
		 this.setSize(485, 355);
		 this.setLocationRelativeTo(null);
		 this.setVisible(true);
		 this.setTitle("Boulder dash");
		 try {
			 this.setIconImage(ImageIO.read(new File("C:\\Users\\rg261\\git\\BoulderDash\\model\\src\\main\\resources\\image\\P.png")));
		 }catch (IOException e) {
			 e.printStackTrace();
		 }
	     this.setContentPane(this.panel);
	     this.setResizable(false);
	  	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	 this.setVisible(true);
	  	 this.addKeyListener(this);
	 }
	 
	 /**
	  * Prints the message.
	  *
	  * @param message
	  *          the message
	  */
	 public void printMessage(final String message) {
	  JOptionPane.showMessageDialog(null, message);
	 }
	 
	 /**
	  * Detect the keyboard active
	  * 
	  * @param keycode
	  * 
	  * @return keyboard touching
	  */
	 public ControllerOrder KeyCode(int keycode){
	        switch(keycode){
	            case KeyEvent.VK_LEFT:
	                return ControllerOrder.LEFT;
	            case KeyEvent.VK_RIGHT:
	                return ControllerOrder.RIGHT;
	            case KeyEvent.VK_UP:
	                return ControllerOrder.UP;
	            case KeyEvent.VK_DOWN:
	                return ControllerOrder.DOWN;
	            default:
	                return null;
	        }
	 }
	 
	 /**
	  * @see java.awt.event.KeyListener
	  */
	 public void keyPressed(KeyEvent e) {
	  try {
		this.getController().orderPerform(this.KeyCode(e.getKeyCode()));
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	  
	 }
	 
	 /**
	  * @see java.awt.event.KeyListener
	  */
	 public void keyReleased(KeyEvent e) {
	  
	 }
	 
	 /**
	  * @see java.awt.event.KeyListener
	  */
	 public void keyTyped(KeyEvent e) {
	  
	 }
	 
	 
	 
	 /*
	  * (non-Javadoc)
	  *
	  * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	  */
	 public void update(Observable Observable, Object arg) {
	        this.panel.setCurrentMap(this.model.convertMap());

	        int[] Player = this.model.getPositionsPlayer();

	        this.panel.setPlayerX(Player[2]);
	        this.panel.setPlayerY(Player[2]);

	        this.panel.Modify();
	        this.repaint();
	    }

}
