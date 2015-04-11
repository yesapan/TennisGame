import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class Barrier2 {
private static final int Y = 350;

	
	private static final int WIDTH = 75;
	private static final int HEIGHT = 20;
	int x = 550;
	int xa = 0;
	private Game game;

	public Barrier2 (Game game) {
		this.game = game;
	}



	public void paint(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}




	

	

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y;
	}
	public int getBotX() {
		return x;
	}

}
