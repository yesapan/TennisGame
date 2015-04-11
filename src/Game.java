

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel implements ActionListener {
	
	Ball ball = new Ball(this);
	Ball2 ball2 = new Ball2(this);
	Ball3 ball3 = new Ball3(this);

	
	Barrier barrier = new Barrier(this);
	
	Bounce bounce = new Bounce(this);
	Barrier2 barrier2 = new Barrier2(this);
	Barrier3 barrier3 = new Barrier3(this);

	
	
     
	public Game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				bounce.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				bounce.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	public void Win(){
		JOptionPane.showMessageDialog(this, "WELL DONE!", "YOU WIN", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "GAME OVER!", "X", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	public void LevelUp() throws InterruptedException{
		
		
		
		while (true) {
		move();
		repaint();
			Thread.sleep(2);
		}}
		public void LevelUp1() throws InterruptedException{
			
			
			
			while (true) {
			move();
			repaint();
				Thread.sleep(1,7);
			}}
			public void LevelUp2() throws InterruptedException{
				
				
				
				while (true) {
				move();
				repaint();
					Thread.sleep(1,3);
				}}
				public void LevelUp3() throws InterruptedException{
					
					
					
					while (true) {
					move();
					repaint();
						Thread.sleep(0,5);
					}
		
			
		
		
	}
	private void move() throws InterruptedException {
		ball.move();
		ball2.move();
		ball3.move();
		bounce.move();
	}
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		/*Graphics2D g2 = (Graphics2D) g;
		
	    Image img1 = Toolkit.getDefaultToolkit().getImage("a.jpg");
	    g2.drawImage(img1, 0, 0, this);*/
	    
		ball.paint(g2d);
		ball2.paint(g2d);
		ball3.paint(g2d);
		barrier.paint(g2d);
		bounce.paint(g2d);
		barrier2.paint(g2d);
		barrier3.paint(g2d);
		
	}



	
		
		

	 
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		JFrame frame = new JFrame("Serdar's Game");
		Game game = new Game();
		frame.add(game);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().add(new Game());
		
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(3);
		}
	
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}