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
 * @author 
 */
public class ViewFrame extends JFrame implements IView, KeyListener, Observer {

	private ViewPanel panel;
	
	/**  States of the game. */
    private boolean death;
	 
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
	 public IController getController() {
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
	public ViewFrame(){
	    this.setSize(498, 447);
	    this.setTitle("Boulder dash");
	    this.setLocationRelativeTo(null);
	    this.addKeyListener(this);
	    this.setResizable(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** Defined to observe it from the view. */
	public void init(IModel model) {
	    this.panel = new ViewPanel();
	    this.setContentPane(this.panel);
	    try{
	        this.setIconImage(ImageIO.read(new File("C:\\Users\\rg261\\git\\BoulderDashFinal\\model\\src\\main\\resources\\image\\P.png")));
	    }catch(IOException e){
	        e.printStackTrace();
	    }
	    this.setVisible(true);
	    this.model = model;
	    this.model.getObservable().addObserver(this);
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
	 
	 public void Run(){
	        while(true){
	            this.panel.repaint();
	            try{
	                Thread.sleep(150);
	            }catch(InterruptedException e){
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 /**
	  * @see java.awt.event.KeyListener
	  */
	 public void keyPressed(KeyEvent e) {
		 if (death) {
		 }
		 else {
			 try {
				 this.getController().orderPerform(this.KeyCode(e.getKeyCode()));
			 } 
			 catch (Exception e1) {
			 }
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

	        this.panel.setPlayerX(Player[0]);
	        this.panel.setPlayerY(Player[1]);
	        
	        if(!(this.model.getIsAlivePlayer())) {
	            this.panel.setDeath(true);
	            this.death = true;
	            this.message();
	            System.exit(0);
	        }

	        this.panel.Modify();
	        this.repaint();
	    }
	 
	 public void printMessage (String message) {
		 JOptionPane.showMessageDialog(null, message);
	 }
	 
	 public void message() {
			this.printMessage("YOU LOSE !!!");
		}

}
