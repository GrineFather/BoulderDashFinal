package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IView;
import contract.IModel;

/**
 * The Class Controller.
 */
public final class Controller extends Thread implements IController {

	/** The  view*/
	private IView view;
	/** The  model*/
	private IModel model;
	/** Last position of the player */
	private int[] lastPositionPlayer = new int[2];


	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.lastPositionPlayer[0] = 0;
		this.lastPositionPlayer[1] = 0;
	}
	/**
	 * 	Set the view.
	 * @param view
	 * 			the view
	 *
	 */

	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 *  Set the model.
	 * @param model
	 * 			the model
	 */

	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Look the movement of the player and his status.
	 *
	 * @param controllerOrder
	 *            the controller order
	 *
	 * @throws Exception for bad direction assign to the player
	 *
	 */

	public void orderPerform(final ControllerOrder controllerOrder) throws Exception {
		switch (controllerOrder) {
			case LEFT:
				this.model.setMovePlayer(-1,0);
				break;
			case RIGHT:
				this.model.setMovePlayer(1,0);
				break;
			case UP:
				this.model.setMovePlayer(0,-1);
				break;
			case DOWN:
				this.model.setMovePlayer(0,1);
				break;
			default:
				break;
		}
	}
}
