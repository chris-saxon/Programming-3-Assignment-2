package pshroom;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * @author Chris Saxon
 *
 */
public class Spores  {

	// Primitives
	private int x;
	private int y;
	private int velocityX;
	private int velocityY;
	private int width;
	private int height;
	private int size;
	private int number;
	
	// Complex 
	private ImageIcon spore;
	private Rectangle location;

	public Spores(Shroom shroom, int x, int y) {

		setX(x);
		setY(y);
		setVelocityX(1);
		setVelocityY(1);
		setWidth(shroom.getBounds().width);
		setHeight(shroom.getBounds().height);
		setSize(120);
		Random rand = new Random();
		spore = new ImageIcon("Spore_Two.png");
		setNumber((rand.nextInt(50)));
		setLocation(new Rectangle(getX(),getY(),spore.getIconWidth(),spore.getIconHeight()));

	}

	public void move() {
		location.x = getX();
		location.y = getY();
		setX(getX() + getVelocityX());
	

	}

	public void bounce() {
		if ((getY() >= 350) || (getY() <= 0)) {
			setVelocityY(getVelocityY() * -1);

		}
		if ((getX() >= 550) || (getX() <= 0)) {
			setVelocityX(getVelocityX() * -1);

		}
	}

	public void paint(Graphics g) {
		//g.drawImage(spore.getImage(), getX(),getY(), null);
		g.drawImage(spore.getImage(), location.x, location.y, location.width,
				location.height, null);

	}

	public void addNumber(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Impact", Font.BOLD, 25));
		g.drawString(Integer.toString(getNumber()), (getX() + getSize() / 2 -15),
				(getY() + getSize() / 2+5));

	}



	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}

	public int getVelocityY() {
		return velocityY;
	}

	public int getSize() {
		return size;
	}

	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
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

	public void setSize(int size) {
		this.size = size;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public Rectangle getLocation() {
		return location;
	}

	public void setLocation(Rectangle location) {
		this.location = location;
	}
}

