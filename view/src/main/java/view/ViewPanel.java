package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ViewPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/** Definition of variables to store images */
	protected BufferedImage Breakable, Wall, Diamond, Player, Inline, Background, Gravity, Lose;

	/** Player's position. */
	private int PlayerX, PlayerY;
	
	 /** State of the game. */
    private boolean death = false;

	/** Definition of the variable that will contain the map. */
	private char[][] CurrentMap = new char[25][30];

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
    protected void setDeath(boolean death) {
        this.death = death;
    }
    
    /**
     * Recovers the state of the game.
     *
     * @return boolean
     */
    protected boolean getDeath() {
        return this.death;
    }

	/** Changes the location of the recovered images. */
	protected void Modify() {
		try {
			this.Breakable = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\B.png"));
			this.Background = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\1.png"));
			this.Wall = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\E.png"));
			this.Inline = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\E.png"));
			this.Diamond = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\D.png"));
			this.Player = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\P.png"));
			this.Gravity = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\G.png"));
			this.Lose = ImageIO.read(new File("C:\\Users\\rg261\\OneDrive\\Bureau\\image\\L.png"));
		} catch (IOException e) {
		}
	}

	/** @see javax.swing.JComponent */
	protected void paintComponent(Graphics Graphic) {
		for (int Y = 0; Y < 450; Y += 16) {
			for (int X = 0; X < 500; X += 16) {
				Graphic.drawImage(this.Background, X, Y, 16, 16, this);
			}
		}
		
		for (int Y = 0; Y < 25; Y++) { // lignes
			   for (int X = 0; X < 30; X++) { // colonnes
			    switch (this.getCurrentMapChar(X,Y)) {
			    case 'B':
			     Graphic.drawImage(this.Breakable, X * 16, Y * 16, 16, 16, this);
			     break;
			    case 'O':
			     Graphic.drawImage(this.Wall, X * 16, Y * 16, 16, 16, this);
			     break;
			    case 'I':
			     Graphic.drawImage(this.Inline, X * 16, Y * 16, 16, 16, this);
			     break;
			    case 'D':
			     Graphic.drawImage(this.Diamond, X * 16, Y * 16, 16, 16, this);
			     break;
			    case 'P':
			     Graphic.drawImage(this.Player, X * 16, Y * 16, 16, 16, this);
			     break;
			    case 'G':
			     Graphic.drawImage(this.Gravity, X * 16, Y * 16, 16, 16, this);
			     break;
			    }
			  }
		}
		if (this.getDeath() == true) {
			for (int Y = 0; Y < 450; Y += 64) {
				for (int X = 0; X < 500; X += 64) {
					Graphic.drawImage(this.Lose, X, Y, 64, 64, this);
				}
			}	
		}
	}
}