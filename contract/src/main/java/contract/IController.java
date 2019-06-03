	package contract;

/**
 * The Interface IController.
 *
 * @author Rowan Geeraert
 */
public interface IController {

	/**
	 * Order perform.
	 *
	 * @param controllerOrder
	 *          the controller order
	 * @throws Exception 
	 */
	public void orderPerform(ControllerOrder controllerOrder) throws Exception;
}
