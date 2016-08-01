package pshroom;

import java.awt.*;
import java.awt.event.*;

import javax.swing.ImageIcon;

public class Player implements KeyListener {

	private int x;
	private int y;
	private int velocityX;
	private int velocityY;
	private int width;
	private int height;
	private ImageIcon image;
	private Rectangle location;

	public Player(Shroom shroom) {
		setWidth((int) shroom.getBounds().width);
		setHeight(shroom.getBounds().height);
		setX(465);
		setY(265);
		shroom.setFocusable(true);
		image = new ImageIcon("player.png");
		location = new Rectangle(getX(), getY(), image.getIconWidth(),
				image.getIconHeight());
	}

	
	public void move() {

		setX(getX() + getVelocityX());
		setY(getY() + getVelocityY());
		location.x = getX() + getVelocityX();
		location.y = getY() + getVelocityY();

		if (getX() <= 0) {
			setX(0);
			setVelocityY(getVelocityY() * -1);
		}
		if (getX() >= 550) {
			setX(550);
			setVelocityY(getVelocityY() * -1);
		}
		if (getY() >= 325) {
			setY(325);
			setVelocityX(getVelocityX() * -1);
		}

		if (getY() <= 0) {
			setY(0);
			setVelocityX(getVelocityX() * -1);
		}

	}

	public void draw(Graphics g) {g.drawImage(image.getImage(), location.x, location.y, location.width,
				location.height, null);

	}

	public void restart() {
		setX(300);
		setY(200);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			setVelocityY(-5);
			break;
		case KeyEvent.VK_DOWN:

			setVelocityY(5);
			break;
		case KeyEvent.VK_LEFT:
			setVelocityX(-5);
			break;
		case KeyEvent.VK_RIGHT:
			setVelocityX(5);
			break;
		case KeyEvent.VK_SPACE:
			setVelocityY(-15);
			break;
		default:
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			setVelocityY(0);
			break;
		case KeyEvent.VK_DOWN:

			setVelocityY(0);
			break;
		case KeyEvent.VK_LEFT:
			setVelocityX(0);
			break;
		case KeyEvent.VK_RIGHT:
			setVelocityX(0);
			break;
		case KeyEvent.VK_SPACE:
			setVelocityY(0);
			break;
		default:
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public Rectangle getLocation() {
		return location;
	}

	public void setLocation(Rectangle location) {
		this.location = location;
	}

}
