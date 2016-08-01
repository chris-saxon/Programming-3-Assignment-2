package pshroom;

import java.awt.Container;
import java.awt.Graphics;

import javax.swing.*;

public class Shroom extends DoubleBuffer implements Runnable {

	private static final long serialVersionUID = 1L;
	private Player player;
	private GameEngine engine;
	private Container container;
	Thread thread = new Thread(this);
	private boolean running;
	private JLabel background;

	public Shroom() {
		engine = new GameEngine(this);
		running = true;
	
	}

	@Override
	public void init() {
		container = getContentPane();
		this.setFocusable(true);
		this.setSize(600, 400);
		player = new Player(this);
		this.addKeyListener(player);
		this.addMouseListener(engine);
		background = new JLabel(new ImageIcon("background.jpg"));

		container.add(background);

	}

	@Override
	public void start() {
		thread.start();
	}

	@Override
	public void stop() {
		running = false;
		JOptionPane.showMessageDialog(this, "Thanks for playing");

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		player.draw(g);
		engine.update(g);
	

	}

	@Override
	public void run() {
		while (running) {
			
			repaint();
			player.move();
			engine.checkForCollision(player);
			
			try {
				Thread.sleep(30);

			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
