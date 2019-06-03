package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.ControllerOrder;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/** Definition of variables to store images */
	protected BufferedImage Breakable, Wall, Diamond, Player, Inline, Background, Gravity;

	/** Player's position. */
	private int PlayerX, PlayerY;

	/** State of the game. */
	private boolean Die = false, Live = false;

	/** Definition of the variable that will contain the map. */
	private char[][] CurrentMap = new char[25][55];

	/** Constructor */
	public ViewPanel() {
		this.Modify();
	}

	/**
	 * Defines the received map to display it.
	 *
	 * @param CurrentWorld The received map.
	 */
	protected void setCurrentMap(char[][] CurrentMap) {
		this.CurrentMap = CurrentMap;
	}

	/**
	 * Get all the characters from the map.
	 *
	 * @return char[][]
	 */
	protected char[][] getCurrentMap() {
		return this.CurrentMap;
	}

	/**
	 * Retrieves a character from the map according to a coordinate.
	 *
	 * @param X Position X.
	 * @param Y Postion Y.
	 * @return char
	 */
	protected char getCurrentMapChar(int X, int Y) {
		return this.CurrentMap[Y][X];
	}

	/**
	 * Defines the player's position X.
	 *
	 * @param PlayerX Defines the x-position of the player.
	 */
	protected void setPlayerX(int PlayerX) {
		this.PlayerX = PlayerX;
	}

	/**
	 * Recovers the player's position X.
	 *
	 * @return int
	 */
	protected int getPlayerX() {
		return this.PlayerX;
	}

	/**
	 * Defines the player's position Y.
	 *
	 * @param PlayerY Defines the x-position of the player.
	 */
	protected void setPlayerY(int PlayerY) {
		this.PlayerY = PlayerY;
	}

	/**
	 * Recovers the player's position Y.
	 *
	 * @return int
	 */
	protected int getPlayerY() {
		return this.PlayerY;
	}

	/**
	 * Defined the state of the game.
	 *
	 * @param Die Define the state of the game on death.
	 */
	protected void setDie(boolean Die) {
		this.Die = Die;
	}

	/**
	 * Recovers the state of the game.
	 *
	 * @return boolean
	 */
	protected boolean getDie() {
		return this.Die;
	}

	/**
	 * Recovers the state of the game.
	 *
	 * @param Live Define the state of the game on victory.
	 */
	protected void setLive(boolean Live) {
		this.Live = Live;
	}

	/**
	 * Recovers the state of the game.
	 *
	 * @return boolean
	 */
	protected boolean getLive() {
		return this.Live;
	}

	/** Changes the location of the recovered images. */
	protected void Modify() {
		try {
			this.Breakable = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\B.png"));
			this.Background = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\1.png"));
			this.Wall = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\O.png"));
			this.Inline = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\I.png"));
			this.Diamond = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\D.png"));
			this.Player = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\P.png"));
			this.Gravity = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\G.png"));
		} catch (IOException e) {
		}
	}

	/** @see javax.swing.JComponent */
	protected void paintComponent(Graphics Graphic) {
		for (int Y = 0; Y < 526; Y += 16) {
			for (int X = 0; X < 526; X += 16) {
				Graphic.drawImage(this.Background, X, Y, 16, 16, this);
			}
		}
		for (int Y = 0; Y < 25; Y++) { // lignes
			   for (int X = 0; X < 55; X++) { // colonnes
			    switch (this.getCurrentMapChar(Y/16,X/16)) {
			    case 'B':
			     Graphic.drawImage(this.Breakable, X * 16, Y * 16, 16, 16, this);
			     break;
			    case 'O':
			     Graphic.drawImage(this.Wall, Y * 16, X * 16, 16, 16, this);
			     break;
			    case 'I':
			     Graphic.drawImage(this.Inline, Y * 16, X * 16, 16, 16, this);
			     break;
			    case 'D':
			     Graphic.drawImage(this.Diamond, Y * 16, X * 16, 16, 16, this);
			     break;
			    case 'P':
			     Graphic.drawImage(this.Player, Y * 16, X * 16, 16, 16, this);
			     break;
			    case 'G':
			     Graphic.drawImage(this.Gravity, Y * 16, X * 16, 16, 16, this);
			     break;
			    }
			  }
		}
	}
}