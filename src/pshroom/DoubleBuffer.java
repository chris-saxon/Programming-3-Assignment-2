package pshroom;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JApplet;

public class DoubleBuffer extends JApplet {

	private static final long serialVersionUID = 1L;
	Image offScreenBuffer;

	public void update(Graphics g) {
		Graphics gr;
		if (offScreenBuffer == null
				|| (!(offScreenBuffer.getWidth(this) == this.getWidth() && offScreenBuffer.getHeight(this) == this.getHeight()))){
			offScreenBuffer = this.createImage(getWidth(), getHeight());
		}
		gr = offScreenBuffer.getGraphics();
		paint(gr);
		g.drawImage(offScreenBuffer, 0, 0, this);
	}
}