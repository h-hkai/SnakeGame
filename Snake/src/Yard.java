import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Yard extends Frame {
	
	PaintThread paintThread = new PaintThread();
	private boolean gameOver = false;

	public static final int ROWS = 50;
	public static final int COLS = 50;
	public static final int BLOCK_SIZE = 10;
	
	private Font fontGameOver = new Font("TimesRoman", Font.PLAIN, 37);
	
	private int sorce = 0;
	
	Snake s = new Snake(this);
	Egg e = new Egg();
	
	Image offScreenImage = null;
	
	public void launch() {
		this.setLocation(200, 200);
		this.setSize(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		this.addKeyListener(new KeyMonitor());
		
		new Thread(paintThread).start();
	}

	
	public static void main(String[] args) {
		new Yard().launch();
	}
	
	public void stop() {
		gameOver = true;
	}
	
	@Override
	public void paint(Graphics arg0) {
		Color c = arg0.getColor();
		arg0.setColor(Color.gray);
		arg0.fillRect(0, 0, COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		
		arg0.setColor(Color.black);
		
		arg0.setColor(Color.pink);
		arg0.drawString("Sorce: " + sorce, 10, 60);
		
		arg0.setColor(c);
		
		s.eat(e);
		e.draw(arg0);
		s.draw(arg0);
		
		if (gameOver) {
			arg0.setColor(Color.black);
			arg0.setFont(fontGameOver);
			arg0.drawString("Game over!", 150, 230);
			paintThread.gameOver();
		}
		
	}
	
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE);
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public int getSorce() {
		return sorce;
	}


	public void setSorce(int sorce) {
		this.sorce = sorce;
	}

	private class PaintThread implements Runnable {
		private boolean running = true;
		public void run() {
			while(running) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void gameOver() {
			running = false;
		}
	}
	
	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			s.keyPressed(e);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
