package pshroom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * @author Chris Saxon
 * @version 1.0
 */

/**
 * @author Christoph
 * 
 */
public class GameEngine implements MouseListener {

	// Data fields, Complex Objects
	private Shroom shroom;
	private Spores[] spore;
	private Health health;
	private Equation equation;
	private Random rand;
	private ImageIcon startBtn;
	private ImageIcon tickBox;
	private ImageIcon cross;
	private Rectangle start;

	// Primitives
	private int correctGuess;
	private int incorrectGuess;

	/**
	 * @param shroom
	 * 
	 *            This is the constructor for the game engine it accepts the
	 *            Shroom class as an argument. It initializes the feild's for
	 *            this class
	 */
	public GameEngine(Shroom shroom) {
		spore = new Spores[3];
		spore[0] = new Spores(shroom, 100, 100);
		spore[1] = new Spores(shroom, 250, 100);
		spore[2] = new Spores(shroom, 400, 100);
		health = new Health();
		rand = new Random();
		equation = new Equation(rand.nextInt(10));
		startBtn = new ImageIcon("start-game.png");
		tickBox = new ImageIcon("tick_box.png");
		cross = new ImageIcon("cross.png");
		start = new Rectangle(110, 140, startBtn.getIconHeight(),
				startBtn.getIconWidth());
		spore[1].setNumber(equation.getNumber());
		setCorrectGuess(0);
		setIncorrectGuess(0);

	}

	/**
	 * This method is called by the Shroom and draws the graphics on the screen
	 * it's delay is controlled by the Thread.Sleep in the Shroom class.
	 * 
	 * @param g
	 */
	public void update(Graphics g) {

		health.drawHealth(g);
		draw(g);

		for (int i = 0; i < spore.length; i++) {
			spore[i].paint(g);
			spore[i].move();
			spore[i].bounce();
			spore[i].addNumber(g);
		}
	}

	/**
	 * This method <b>checkForCollision</b> accepts an instance of Player as an
	 * argument. The purpose of this method is to check where the player
	 * intersects with the spores. This is done by calling the intersects
	 * method. If there is collision then an if statement will check to see if
	 * it's the correct number for the equation.
	 * 
	 * @param player
	 */
	public void checkForCollision(Player player) {
		for (int i = 0; i < spore.length; i++) {
			if (player.getLocation().getBounds()
					.intersects(spore[i].getLocation().getBounds())) {
				if (spore[i].getNumber() == equation.getNumber()) {
					correctGuess();
				} else {
					incorrectGuess();
				}
			}
		}
	}

	/**
	 * This method is called when the player intersects with a spore containing
	 * the correct number for the equation.
	 */
	public void correctGuess() {
		setCorrectGuess(getCorrectGuess() + 1);
	}

	public void incorrectGuess() {
		health.setHealth(health.getHealth() - 33);
		setIncorrectGuess(getIncorrectGuess() + 1);
	}

	/**
	 * This method is called by the update method and is used to draw the
	 * graphics on the screen. It requires an instance of the graphics class to
	 * be called.
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {

		// g.drawImage(startBtn.getImage(), 110, 140, 380, 134, null);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 24));

		if (health.getHealth() <= 0) {
			g.drawString(equation.getAnswer(), 25, 40);
		} else {
			g.drawString(equation.getEquation(), 25, 40);
		}
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(Integer.toString(getCorrectGuess()), 270, 385);
		g.drawString(Integer.toString(getIncorrectGuess()), 315, 385);

		// g.drawImage(tickBox.getImage(),158,5,null);

		g.drawImage(cross.getImage(), 158, 5, null);

	}

	/*
	 * This is the getter method that returns the rectangle value;
	 * @return
	 */
	public Rectangle getStart() {
		return start;
	}

	public void setStart(Rectangle start) {
		this.start = start;
	}

	/**
	 * 
	 * @return correctGuess
	 */
	public int getCorrectGuess() {
		return correctGuess;
	}

	public int getIncorrectGuess() {
		return incorrectGuess;
	}

	public void setCorrectGuess(int correctGuess) {
		this.correctGuess = correctGuess;
	}

	public void setIncorrectGuess(int incorrectGuess) {
		this.incorrectGuess = incorrectGuess;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.equals(start.getBounds())) {
			JOptionPane.showMessageDialog(shroom, "DAHDAH");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}
