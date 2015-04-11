import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Ball3 {
	private static final int DIAMETER = 15;
	int puan=0;
	
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	Image img1;
	int limit =30;
	private Game game;
	
	public Ball3(Game game) {
		this.game= game;
		
	}
	



	void move() throws InterruptedException {
		if (x + xa < 0)
			xa = 1;
		if (x + xa > game.getWidth() - DIAMETER )
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() )
			game.gameOver();
		if (collision()){
			ya = -1;
			y = game.bounce.getTopY() - DIAMETER;
			
			puan = puan+10;
			System.out.println(puan);
			for(int i = puan;i==30;i--){
				game.LevelUp();
			}
			for(int i = puan;i==60;i--){
				game.LevelUp1();
			}
			for(int i = puan;i==90;i--){
				game.LevelUp2();
			}
			for(int i = puan;i==150;i--){
				game.LevelUp3();
			}
			
		}
		
		
		if (collision2()){
			if (y + ya < 0)
				ya = 1;
			if (y + ya > game.barrier.getTopY() - DIAMETER )
				ya=-1;
			if (y + ya > 0)
				ya = -1;
			if (y + ya > game.barrier.getTopY() - DIAMETER )
				ya=1;
			
			}
		
		if (collision3()){
			
			if (y + ya < 0)
				ya = 1;
			if (y + ya > game.barrier.getTopY() - DIAMETER )
				ya=-1;
			if (y + ya > 0)
				ya = -1;
			if (y + ya < game.barrier.getTopY() - DIAMETER )
				ya=1;
		}
if (collision4()){
	if (y + ya < 0)
		ya = -1;
	if (y + ya > game.barrier.getTopY() - DIAMETER )
		ya=1;
	if (y + ya < 0)
		ya = 1;
	if (y + ya > game.barrier.getTopY() - DIAMETER )
		ya=-1;
	
		}
		if(puan==30 ){
			
				
				limit=60;
			
			
			
		}
		if(puan==60 ){
			
			
			limit=90;
		
		
		
	}
	if(puan==90 ){
			
			
			limit=150;
		
		
		
	}
	if(puan==150 ){
		
		
		limit=170;
	
	
	
}
if(puan==170 ){
		
		
game.Win();
	
	
	
}
			
		
		
		x = x + xa;
		y = y + ya;
	}

		
	

	private boolean collision() {
		return game.bounce.getBounds().intersects(getBounds());
	}
	private boolean collision2() {
		return game.barrier.getBounds().intersects(getBounds());
	}
	private boolean collision3() {
		return game.barrier2.getBounds().intersects(getBounds());
	
	}
	private boolean collision4() {
		return game.barrier3.getBounds().intersects(getBounds());
	}
	
	public void paint(Graphics2D g) {
		
		 
		/* Image img1 = Toolkit.getDefaultToolkit().getImage("serdar.png");
		 g.drawImage(img1, x, y, game); */ //draw image
		g.setColor(Color.black);
		g.fillOval(x, y, DIAMETER, DIAMETER);
		g.setColor(Color.red);
		g.drawString("POÝNTS:(BALL3) "+puan+"/"+limit, 25, 45);
		 
		
		
	}
	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}