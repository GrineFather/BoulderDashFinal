package contract;

import java.util.Observable;

public interface IModel {


	/**
	 * Gets the alive state from the player.
	 *
	 * @return the alive state from the player
	 */
	boolean getIsAlivePlayer();

	/**
	 * Gets the position of the player.
	 *
	 * @return the position of the player
	 */
	int[] getPositionsPlayer();

	/**
	 * Try to move the player.
	 *
	 * @param x
	 * 			the x position of the move
	 * @param y
	 * 			the y position of the move
	 *
	 * @throws Exception when a bad position is given in parameter
	 */
	void setMovePlayer(int x, int y) throws Exception;
	
	/**
	 * Convert the world to a char array in two dimensions.
	 *
	 * @return the converted char array
	 */
	char[][] convertMap();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
