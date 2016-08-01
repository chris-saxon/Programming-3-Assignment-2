package pshroom;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Health {

	private int health;
	private ImageIcon heart;

	public Health() {
		setHealth(100);
		heart = new ImageIcon("heart.png");
	}

	public void drawHealth(Graphics g) {

		switch (getHealth()) {
		case 100:
			g.drawImage(heart.getImage(), 540, 25, null);
			g.drawImage(heart.getImage(), 480, 25, null);
			g.drawImage(heart.getImage(), 420, 25, null);
			break;
		case 66:
			g.drawImage(heart.getImage(), 480, 25, null);
			g.drawImage(heart.getImage(), 420, 25, null);
			break;
		case 33:
			g.drawImage(heart.getImage(), 420, 25, null);
			break;
		case 0:
			break;
		default:
			break;
		}

	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}
}
